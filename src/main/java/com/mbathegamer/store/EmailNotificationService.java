package com.mbathegamer.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("email-notification")
public class EmailNotificationService implements NotificationService {
  @Override
  public void send(String message) {
    System.out.println("Sending email: " + message);
  }
}
