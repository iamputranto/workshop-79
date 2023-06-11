package com.p79.orderservice.dto;

import com.p79.orderservice.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderRequest {
    private Integer totalQuantity;
    private List<OrderItem> orderItemList;
}