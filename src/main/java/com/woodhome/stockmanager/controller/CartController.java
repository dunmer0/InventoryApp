package com.woodhome.stockmanager.controller;

import com.woodhome.stockmanager.model.Cart;
import com.woodhome.stockmanager.service.ICartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final ICartService transactionService;

    public CartController(ICartService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Cart> addTransaction(@RequestBody Cart cart) {
        Cart newCart = this.transactionService.addTransaction(cart);
        return new ResponseEntity<>(newCart, HttpStatus.CREATED);
    }
}
