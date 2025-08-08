package com.mbathegamer.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Value("${payment-gateway:stripe}")
  private String paymentGateaway;

  @Bean
  // @Lazy
  // @Scope("prototype")
  PaymentService stripe() {
    return new StripePaymentService();
  }

  @Bean
  PaymentService paypal() {
    return new StripePaymentService();
  }

  @Bean
  OrderService orderService() {
    if (paymentGateaway.equals("stripe")) {
      return new OrderService(stripe());
    } else {
      return new OrderService(paypal());
    }
  }
}
