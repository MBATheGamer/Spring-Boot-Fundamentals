package com.mbathegamer.store;

import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    user.addTag("tag1");

    System.out.println(user);
  }
}
