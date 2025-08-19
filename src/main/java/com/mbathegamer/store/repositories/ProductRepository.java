package com.mbathegamer.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mbathegamer.store.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}