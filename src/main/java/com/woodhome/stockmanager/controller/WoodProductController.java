package com.woodhome.stockmanager.controller;

import com.woodhome.stockmanager.model.WoodProduct;
import com.woodhome.stockmanager.model.WoodProductStockRequest;
import com.woodhome.stockmanager.service.impl.WoodProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wood-products")
public class WoodProductController {
    private final WoodProductServiceImpl woodProductServiceImpl;


    public WoodProductController(WoodProductServiceImpl woodProductServiceImpl) {
        this.woodProductServiceImpl = woodProductServiceImpl;
    }


    @GetMapping()
    public ResponseEntity<List<WoodProduct>> getAllWoodProducts() {
        List<WoodProduct> woodProductList = this.woodProductServiceImpl.findAllWoodProducts();
        return new ResponseEntity<>(woodProductList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WoodProduct> getWoodProduct(@PathVariable Long id) {
        WoodProduct woodProduct = this.woodProductServiceImpl.findWoodProductById(id);
        return new ResponseEntity<>(woodProduct, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<WoodProduct> addWoodProduct(@RequestBody WoodProduct woodProduct) {
        WoodProduct newProduct = this.woodProductServiceImpl.addWoodProduct(woodProduct);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<WoodProduct> updateWoodProduct(@RequestBody WoodProductStockRequest stock) {
        WoodProduct updatedWoodProduct = this.woodProductServiceImpl.updateWoodProduct(stock);
        return new ResponseEntity<>(updatedWoodProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWoodProduct(@PathVariable Long id) {
        this.woodProductServiceImpl.deleteWoodProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
