package com.p79.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Inventory {
    @Id
    private String id;
    private String productId;
    private Integer stock;

}