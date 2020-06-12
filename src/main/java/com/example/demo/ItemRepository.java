package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Long> {
    Item findByItemName(String itmeName);
}
