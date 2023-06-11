package com.p79.orderservice.service;

import com.p79.orderservice.dto.OrderRequest;
import com.p79.orderservice.model.Order;
import com.p79.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(OrderRequest orderRequest) {
        Order newOrder = Order.builder()
                .totalPrice(0)
                .totalQuantity(orderRequest.getTotalQuantity())
                .orderItemLists(orderRequest.getOrderItemList())
                .build();

        return orderRepository.save(newOrder);
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrder(String id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()) {
            return order.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
    }

    public Order updateOrder(String id, OrderRequest orderRequest) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()) {
            Order updatedOrder = order.get();

            updatedOrder.setTotalQuantity(orderRequest.getTotalQuantity());
            updatedOrder.setTotalPrice(0);
            updatedOrder.setOrderItemLists(orderRequest.getOrderItemList());

            return orderRepository.save(updatedOrder);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
    }

    public String deleteOrder(String id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()) {
            orderRepository.deleteById(id);
            return "Order deleted";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
    }


}

