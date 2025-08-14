package com.mbathegamer.store;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mbathegamer.store.entities.Profile;
import com.mbathegamer.store.entities.User;

@SpringBootApplication
public class StoreApplication {
  public static void main(String[] args) {
    // ApplicationContext context = SpringApplication.run(
    // StoreApplication.class,
    // args);

    var user = User.builder()
        .name("John")
        .email("john@gmail.com")
        .password("password")
        .build();

    var profile = Profile.builder()
        .bio("bio")
        .build();

    user.setProfile(profile);
    profile.setUser(user);

    System.out.println(user);
  }
}
