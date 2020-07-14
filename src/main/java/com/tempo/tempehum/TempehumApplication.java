package com.tempo.tempehum;

import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.User;
import com.tempo.tempehum.accessingdatapostgres.repository.DeviceRepository;
import com.tempo.tempehum.accessingdatapostgres.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class TempehumApplication {

	private static final Logger log = LoggerFactory.getLogger(TempehumApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TempehumApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(UserRepository userRepository,
										 DeviceRepository deviceRepository) {
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

			Optional<User> user = userRepository.findById(4);

			if (user.isPresent()) {
				for (Device d : user.get().getDevices()) {
					log.info(d.getDeviceName());
				}
			}

		};
	}
}
