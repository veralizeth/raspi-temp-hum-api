package com.tempo.tempehum.accessingdatapostgres.utils;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tempo.tempehum.accessingdatapostgres.messages.ReportedMessage;
import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.Humidity;
import com.tempo.tempehum.accessingdatapostgres.model.Temperature;
import com.tempo.tempehum.accessingdatapostgres.model.User;
import com.tempo.tempehum.accessingdatapostgres.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.List;


@Component
public class SQSUtil {

    @Value("${sqs.url}")
    private String sqsUrl;

    @Value("${aws.accessKey}")
    private String awsAccessKey;

    @Value("${aws.secretKey}")
    private String awsSecretKey;

    @Value("${aws.region}")
    private String awsRegion;

    private AmazonSQS amazonSQS;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private HumidityRespository humidityRespository;

    private static final Logger logger = LoggerFactory.getLogger(SQSUtil.class);

    @PostConstruct
    private void postConstructor() {

        logger.info("SQS URL: " + sqsUrl);

        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(awsAccessKey, awsSecretKey)
        );

        this.amazonSQS = AmazonSQSClientBuilder.standard().withCredentials(awsCredentialsProvider).build();
    }

    public void startListeningToMessages() {
        
        final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(sqsUrl)
                .withMaxNumberOfMessages(1)
                .withWaitTimeSeconds(3);

        while(true) {
            Message exceptionMessage = null;
            try {
                final List<Message> messages = amazonSQS.receiveMessage(receiveMessageRequest).getMessages();

                ObjectMapper mapper = new ObjectMapper();

                for (Message messageObject : messages) {
                    exceptionMessage = messageObject;
                    String message = messageObject.getBody();

                    ReportedMessage reportedMessage = mapper.readValue(message, ReportedMessage.class);

                    System.out.println(reportedMessage.getReported().getTimestamp());

                    String deviceName = reportedMessage.getReported().getDeviceName();
                    double temperature = reportedMessage.getReported().getTemperature();
                    double humidity = reportedMessage.getReported().getHumidity();
                    Timestamp timestamp = reportedMessage.getReported().getTimestamp();

                    Device device = deviceRepository.findByDeviceName(deviceName);
                    User user = UserRepositoryHelper.getDefaultUser(userRepository);

                    if (device == null){
                        device = new Device(deviceName, user);
                        deviceRepository.save(device);
                    }else {

                        Temperature temperatureReported = new Temperature(temperature, device, timestamp);
                        temperatureRepository.save(temperatureReported);

                        Humidity humidityReported = new Humidity(humidity, device, timestamp);
                        humidityRespository.save(humidityReported);

                        deleteMessage(messageObject);
                    }
//                  deleteMessage(messageObject);
                }
            }catch (Exception e) {
                if (exceptionMessage != null) {
                    deleteMessage(exceptionMessage);
                }
            }
        }
    }

    private void deleteMessage(Message messageObject) {

        final String messageReceiptHandle = messageObject.getReceiptHandle();
        amazonSQS.deleteMessage(new DeleteMessageRequest(sqsUrl, messageReceiptHandle));

    }
}