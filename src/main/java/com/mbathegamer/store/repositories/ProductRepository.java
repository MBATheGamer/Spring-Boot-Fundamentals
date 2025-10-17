package com.mbathegamer.store.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mbathegamer.store.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
  // String
  List<Product> findByName(String name);

  List<Product> findByNameLike(String name);

  List<Product> findByNameNotLike(String name);

  List<Product> findByNameContaining(String name);

  List<Product> findByNameContains(String name);

  List<Product> findByNameStartingWith(String name);

  List<Product> findByNameEndingWith(String name);

  List<Product> findByNameEndingWithIgnoreCase(String name);

  // Numbers
  List<Product> findByPrice(BigDecimal price);

  List<Product> findByPriceGreaterThan(BigDecimal price);

  List<Product> findByPriceGreaterThanEqual(BigDecimal price);

  List<Product> findByPriceLessThanEqual(BigDecimal price);

  List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

  // Null
  List<Product> findByDescriptionNull();

  List<Product> findByDescriptionNotNull();

  // Multiple conditions
  List<Product> findByDescriptionNullAndNameNull();

  // Sort (OrderBy)
  List<Product> findByNameOrderByPriceDesc(String name);

  // Limit (Top/First)
  List<Product> findTop5ByNameOrderByPriceDesc(String name);

  List<Product> findFirst5ByNameOrderByPrice(String name);

  // Find products whose prices are in a given range and sort by name
  // List<Product> findByPriceBetweenOrderByName(BigDecimal min, BigDecimal max);
  // This is same query like above but with SQL
  // @Query(
  // value = "select * from products p where p.price between :min and :max order
  // by p.name",
  // nativeQuery = true
  // )
  // This is same query like above but with JPQL
  @Query("select p from Product p join p.category where p.price between :min and :max order by p.name")
  List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

  @Query("select count(*) from Product p where p.price between :min and :max")
  long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

  @Modifying
  @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
  void updatePriceByCategory(@Param("newPrice") BigDecimal newPrice, @Param("categoryId") Byte categoryId);
}