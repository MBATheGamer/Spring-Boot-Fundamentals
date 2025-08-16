package com.mbathegamer.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mbathegamer.store.repositories.UserRepository;

@SpringBootApplication
public class StoreApplication {
  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(
        StoreApplication.class,
        args);

    var repository = context.getBean(UserRepository.class);

    // var user = User.builder()
    // .name("John")
    // .email("john@gmail.com")
    // .password("password")
    // .build();

    // repository.save(user);

    // var user = repository.findById(1L).orElseThrow();
    // System.out.println(user.getEmail());

    // repository.findAll().forEach(user -> System.out.println(user.getEmail()));

    repository.deleteById(1L);
  }
}
