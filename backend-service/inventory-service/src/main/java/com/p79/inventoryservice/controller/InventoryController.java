package com.p79.inventoryservice.controller;

import com.p79.inventoryservice.dto.InventoryRequest;
import com.p79.inventoryservice.model.Inventory;
import com.p79.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/inventories")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory createInventory(@RequestBody InventoryRequest inventoryRequest) {
        return inventoryService.createInventory(inventoryRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Inventory getInventory(@PathVariable("id") String id) {
        return inventoryService.getInventory(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Inventory updateInventory(@PathVariable("id") String id, @RequestBody InventoryRequest inventoryRequest) {
        return inventoryService.updateInventory(id, inventoryRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteInventory(@PathVariable("id") String id) {
        return inventoryService.deleteInventory(id);
    }


}