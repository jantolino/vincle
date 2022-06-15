package com.vincle.ejercicio_dos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vincle.ejercicio_dos.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

}
