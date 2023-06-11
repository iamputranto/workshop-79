package com.p79.orderservice.repository;

import com.p79.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String>{

}