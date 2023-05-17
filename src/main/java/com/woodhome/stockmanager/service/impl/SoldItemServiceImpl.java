package com.woodhome.stockmanager.service.impl;

import com.woodhome.stockmanager.exception.InventoryAPIException;
import com.woodhome.stockmanager.model.SoldItem;
import com.woodhome.stockmanager.model.Cart;
import com.woodhome.stockmanager.model.WoodProduct;
import com.woodhome.stockmanager.repo.SoldItemRepo;
import com.woodhome.stockmanager.repo.CartRepo;
import com.woodhome.stockmanager.service.ISoldItemService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldItemServiceImpl implements ISoldItemService {
    private final SoldItemRepo soldItemRepo;
    private final CartRepo cartRepo;


    public SoldItemServiceImpl(SoldItemRepo soldItemRepo, CartRepo cartRepo) {
        this.soldItemRepo = soldItemRepo;
        this.cartRepo = cartRepo;
    }

    public SoldItem addSoldItem(long transactionId, WoodProduct woodProduct) {
        SoldItem soldItem = new SoldItem();
        soldItem.setName(woodProduct.getName());
        soldItem.setPrice(woodProduct.getPrice());
        soldItem.setWoodProductID(woodProduct.getWoodProductId());

        Cart cart = this.cartRepo.getReferenceById(transactionId);
        soldItem.setCart(cart);
        return this.soldItemRepo.save(soldItem);
    }

    @Override
    public SoldItem updateSoldItem(SoldItem soldItem) {
        return null;
    }



    public List<SoldItem> findAllSoldItems(long cartId) {
        return this.soldItemRepo.getSoldItemsByCartCartId(cartId);
    }



    public SoldItem updateSoldItem(long cartId, SoldItem soldItem) {

        return this.soldItemRepo.save(soldItem);
    }
    @Override
    public SoldItem findById(long cartId, long soldItemId) {
        Cart cart = this.cartRepo.getReferenceById(cartId);
        SoldItem soldItem = this.soldItemRepo.getReferenceById(soldItemId);
        if (!soldItem.getCart().getCartId().equals(cart.getCartId())) {
            throw new InventoryAPIException(
                    HttpStatus.BAD_REQUEST, "Comment does not belong to post"
            );
        }
        return soldItem;
    }

    public void deleteSoldItem(long id) {
        this.soldItemRepo.deleteById(id);
    }
}
