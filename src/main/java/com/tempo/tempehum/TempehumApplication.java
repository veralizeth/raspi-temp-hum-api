package com.tempo.tempehum;

import com.tempo.tempehum.accessingdatapostgres.model.*;
import com.tempo.tempehum.accessingdatapostgres.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TempehumApplication {

	private static final Logger log = LoggerFactory.getLogger(TempehumApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TempehumApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(UserRepository userRepository,
										 DeviceRepository deviceRepository,
										 TemperatureRepository temperatureRepository,
										 HumidityRepository humidityRepository,
										 TimerRepository timerRepository) {
		return args -> {

//			// create a new User
//			User user = new User("John Doe", "123456");
//
//			// save the User
//			userRepository.save(user);
//
//			// create and save new Devices
//			deviceRepository.save(new Device("Contents", user));
//			deviceRepository.save(new Device("Device 8", user));

//			// create a new User
//			User user1 = new User("Doe", "@VERA");
//			userRepository.save(user1);
//			Device device1 = new Device("Raspi2", user1);
//			deviceRepository.save(device1);
//
//			// create and save new Temperatures
//			temperatureRepository.save(new Temperature(27.9, device1,"23-08-12"));

			// create a new User
//			User user2 = new User("Doe2", "@VERA2");
//			userRepository.save(user2);
//			Optional<User> user1 = Optional.ofNullable(userRepository.findByname("Doe2"));
//			System.out.println(user1.get().getName());
//			Device device2 = new Device("Raspi3", user1.get());
//			deviceRepository.save(device2);


			//create and save new Humidities
//			Optional<Device> device2 = deviceRepository.findById(8);
//			humidityRespository.save(new Humidity(20.9, device2.get(),"23-01-12"));

//			// create and save new Humidities
//			Optional<Device> device2 = deviceRepository.findById(8);
//			Timestamp startTime = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
//			Timestamp endTime = Timestamp.valueOf("2020-05-01 12:30:00");
//			timerRepository.save(new Timer(startTime, endTime, true, device2.get()));

//			Optional<User> user = userRepository.findById(4);
//
//			if (user.isPresent()) {
//				for (Device d : user.get().getDevices()) {
//					log.info(d.getDeviceName());
//				}
//			}

//			Optional<Device> device = deviceRepository.findById(8);
////			System.out.println(device);
//			if (device.isPresent()) {
//				for (Temperature t : device.get().getTemperatures()) {
//					System.out.println(t.getValue());
////					log.info(t.getValue());
//				}
//			}

//			Optional<Device> device1 = deviceRepository.findById(8);
////			System.out.println(device);
//			if (device1.isPresent()) {
//				for (Humidity h : device1.get().getHumidities()) {
//					System.out.println(h.getValue());
////					log.info(t.getValue());
//				}
//			}

//			if (device1.isPresent()) {
//				for (Timer timer : device1.get().getTimers()) {
//					System.out.println(timer.getStarTime());
//					System.out.println(timer.getEndTime());
//				}
//			}
//			String string = "2020-07-16 13:49:39";
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
//			LocalDate date = LocalDate.parse(string, formatter);
//			System.out.println(date); // 2010-01-02

//			Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm z").parse("2020-07-17 00:46:59");
//			Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm z").parse("2020-07-17 00:50:00");

			Instant startInstant = Instant.parse( "2020-07-17T00:46:59Z" );
			Instant endInstant = Instant.parse( "2020-07-17T00:50:00Z" );

			Date startDate = Date.from(startInstant);
			Date endDate = Date.from(endInstant);

			List<Humidity> result = humidityRepository.findAllByTimeStampBetween(startDate, endDate);

			System.out.println(result.size());

//			List<Humidity> all = humidityRepository.findAllByDate(
//					new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-07-17 00:46:59"));
//
//			System.out.println(all);

			};
	}
}
