package com.woodhome.stockmanager.controller;

import com.woodhome.stockmanager.model.SoldItem;
import com.woodhome.stockmanager.model.WoodProduct;
import com.woodhome.stockmanager.service.ISoldItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class SoldItemController {

    private final ISoldItemService soldItemService;


    public SoldItemController(ISoldItemService soldItemService) {
        this.soldItemService = soldItemService;
    }

    @PostMapping("/{cartId}/sold-items")
    public ResponseEntity<SoldItem> addSoldItem(@PathVariable(value = "cartId") long cartId,
                                                @RequestBody WoodProduct woodProduct) {
        SoldItem soldItem = this.soldItemService.addSoldItem(cartId, woodProduct);
        return new ResponseEntity<>(soldItem, HttpStatus.CREATED);
    }

//    @PutMapping("/{cartId}/sold-items")
//    public ResponseEntity<SoldItem> updateSoldItem(@PathVariable(value = "cartId") long cartId,
//                                                   @RequestBody SoldItem soldItem) {
//        SoldItem updatedSoldItem = this.soldItemService.updateSoldItem(soldItem);
//        return new ResponseEntity<>(updatedSoldItem, HttpStatus.OK);
//    }

    @GetMapping("/{cartId}/sold-items")
    public ResponseEntity<List<SoldItem>> getAllSoldProducts(@PathVariable long cartId) {
        List<SoldItem> soldItemsList = this.soldItemService.findAllSoldItems(cartId);
        return new ResponseEntity<>(soldItemsList, HttpStatus.OK);
    }

}
