package com.mbathegamer.store;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class InMemoryUserRepository implements UserRepository {
  private final HashMap<String, User> users = new HashMap<>();

  @Override
  public void save(User user) {
    System.out.println("Saving user: " + user);
    users.put(user.getEmail(), user);
  }

  @Override
  public User findByEmail(String email) {
    return users.getOrDefault(email, null);
  }
}
