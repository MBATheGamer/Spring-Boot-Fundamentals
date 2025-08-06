package com.mbathegamer.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  PaymentService stripe() {
    return new StripePaymentService();
  }

  @Bean
  PaymentService paypal() {
    return new StripePaymentService();
  }

  @Bean
  OrderService orderService() {
    return new OrderService(stripe());
  }
}
