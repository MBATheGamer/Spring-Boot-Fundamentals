package com.mbathegamer.store;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {
  public static void main(String[] args) {
    // SpringApplication.run(StoreApplication.class, args);
    var orderService = new OrderService();
    orderService.setPaymentService(new StripePaymentService());
    orderService.placeOrder();

    // orderService = new OrderService(new PayPalPaymentService());
    orderService.setPaymentService(new PayPalPaymentService());
    orderService.placeOrder();
  }
}
