package com.p79.orderservice.controller;

import com.p79.orderservice.service.OrderService;
import com.p79.orderservice.dto.OrderRequest;
import com.p79.orderservice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable("id") String id) {
        return orderService.getOrder(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@PathVariable("id") String id, @RequestBody OrderRequest orderRequest) {
        return orderService.updateOrder(id, orderRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteOrder(@PathVariable("id") String id) {
        return orderService.deleteOrder(id);
    }


}