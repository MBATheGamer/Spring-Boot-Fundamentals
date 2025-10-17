package com.mbathegamer.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mbathegamer.store.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}