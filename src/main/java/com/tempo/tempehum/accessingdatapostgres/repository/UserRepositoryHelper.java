package com.tempo.tempehum.accessingdatapostgres.repository;
import com.tempo.tempehum.accessingdatapostgres.model.User;

public class UserRepositoryHelper {

    public static User getDefaultUser(UserRepository userRepository) {
        User defaultUser = userRepository.findByName("DefaultUser");
        if (defaultUser == null) {
            defaultUser = new User("DefaultUser","default@gmail.com");
            userRepository.save(defaultUser);
        }
        return defaultUser;
    }
}
