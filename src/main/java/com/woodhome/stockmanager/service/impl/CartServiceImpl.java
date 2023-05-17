package com.woodhome.stockmanager.service.impl;

import com.woodhome.stockmanager.model.Cart;
import com.woodhome.stockmanager.repo.CartRepo;
import com.woodhome.stockmanager.service.ICartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {
    private final CartRepo cartRepo;

    public CartServiceImpl(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    public Cart addTransaction(Cart cart) {
        return this.cartRepo.save(cart);
    }

    public Cart findTransactionById(long id) {
        return this.cartRepo.getReferenceById(id);
    }
}
