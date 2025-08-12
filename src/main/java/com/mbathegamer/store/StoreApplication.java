package com.mbathegamer.store;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mbathegamer.store.entities.Address;
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

    var address = Address.builder()
        .street("street")
        .city("city")
        .state("state")
        .zip("zip")
        .build();

    user.addAddress(address);

    System.out.println(user);
  }
}
