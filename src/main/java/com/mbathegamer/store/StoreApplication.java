package com.mbathegamer.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);

    var userService = context.getBean(UserService.class);
    userService.registerUser(
        new User(1L, "johndoe@gmail.com", "abc123", "John Doe"));
    // userService.registerUser(
    // new User(1L, "johndoe@gmail.com", "abc123", "John Doe")
    // );

    // var resource = context.getBean(HeavyResource.class);

    // var manager = context.getBean(NotificationManager.class);
    // manager.sendNotification("Hello, this is a test message!");

    // var orderService = context.getBean(OrderService.class);
    // orderService.placeOrder();

    // var orderService2 = context.getBean(OrderService.class);

    // var orderService = new OrderService();
    // orderService.setPaymentService(new StripePaymentService());
    // orderService.placeOrder();

    // orderService = new OrderService(new PayPalPaymentService());
    // orderService.setPaymentService(new PayPalPaymentService());
    // orderService.placeOrder();

    context.close();
  }
}
