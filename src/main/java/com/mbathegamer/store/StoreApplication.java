package com.mbathegamer.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {
  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

    var orderService = context.getBean(OrderService.class);
    orderService.placeOrder();

    // var orderService = new OrderService();
    // orderService.setPaymentService(new StripePaymentService());
    orderService.placeOrder();

    // orderService = new OrderService(new PayPalPaymentService());
    // orderService.setPaymentService(new PayPalPaymentService());
    // orderService.placeOrder();
  }
}
