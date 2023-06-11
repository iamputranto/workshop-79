package com.p79.inventoryservice.repository;

import com.p79.inventoryservice.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Inventory, String>{

}