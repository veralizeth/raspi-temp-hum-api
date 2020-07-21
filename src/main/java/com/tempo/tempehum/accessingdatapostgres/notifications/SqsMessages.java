package com.tempo.tempehum.accessingdatapostgres.notifications;
import com.tempo.tempehum.accessingdatapostgres.utils.SQSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SqsMessages implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private SQSUtil sqsUtil;

    @Value("${sqs.active}")
    private String sqsActive;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (!sqsActive.equals("true")) {
            return;
        }
        sqsUtil.startListeningToMessages();
    }
}


