package com.mbathegamer.store.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.mbathegamer.store.entities.Address;
import com.mbathegamer.store.entities.User;
import com.mbathegamer.store.repositories.AddressRepository;
import com.mbathegamer.store.repositories.CategoryRepository;
import com.mbathegamer.store.repositories.ProductRepository;
import com.mbathegamer.store.repositories.ProfileRepository;
import com.mbathegamer.store.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  private final AddressRepository addressRepository;
  private final UserRepository userRepository;
  private final ProfileRepository profileRepository;

  private final EntityManager entityManager;

  @Transactional
  public void showEntityState() {
    var user = User.builder()
        .name("John Doe")
        .email("john.doe@example.com")
        .password("password")
        .build();

    if (entityManager.contains(user)) {
      System.out.println("Persistent");
    } else {
      System.out.println("Transient / Detached");
    }

    userRepository.save(user);

    if (entityManager.contains(user)) {
      System.out.println("Persistent");
    } else {
      System.out.println("Transient / Detached");
    }
  }

  @Transactional
  public void showRelatedEntities() {
    var profile = profileRepository.findById(2L).orElseThrow();
    System.out.println(profile.getBio());
  }

  public void fetchAddress() {
    var address = addressRepository.findById(1L).orElseThrow();

    System.out.println(address.getStreet());
  }

  public void persistRelated() {
    var user = User.builder()
        .name("John Doe")
        .email("john.doe@example.com")
        .password("password")
        .build();

    var address = Address.builder()
        .street("street")
        .city("city")
        .state("state")
        .zip("zip")
        .build();

    user.addAddress(address);

    userRepository.save(user);
    // addressRepository.save(address);
  }

  @Transactional
  public void deleteRelated() {
    var user = userRepository.findById(1L).orElseThrow();
    var address = user.getAddresses().getFirst();
    user.removeAddress(address);
    userRepository.save(user);
  }

  @Transactional
  public void manageProducts() {
    // var category = new Category("category1");

    // var category = categoryRepository.findById(1L).orElseThrow();

    // var product = Product.builder()
    // .name("product1")
    // .description("description1")
    // .price(BigDecimal.valueOf(1))
    // .category(category)
    // .build();

    // productRepository.save(product);

    // var user = userRepository.findById(2L).orElseThrow();
    // var products = productRepository.findAll();

    // products.forEach(user::addFavoriteProduct);
    // userRepository.save(user);

    productRepository.deleteById(4L);
  }

  @Transactional
  public void updateProductPrices() {
    productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte) 1);
  }
}
