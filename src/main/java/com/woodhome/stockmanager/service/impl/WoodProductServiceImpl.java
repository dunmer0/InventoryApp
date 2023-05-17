package com.woodhome.stockmanager.service.impl;

import com.woodhome.stockmanager.model.WoodProduct;
import com.woodhome.stockmanager.model.WoodProductStockRequest;
import com.woodhome.stockmanager.repo.WoodProductRepo;
import com.woodhome.stockmanager.service.IWoodProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WoodProductServiceImpl implements IWoodProductService {

    private final WoodProductRepo woodProductRepo;

    public WoodProductServiceImpl(WoodProductRepo woodProductRepo) {
        this.woodProductRepo = woodProductRepo;
    }

    public WoodProduct addWoodProduct(WoodProduct woodProduct){
        return woodProductRepo.save(woodProduct);
    }

    public List<WoodProduct> findAllWoodProducts() {
        return this.woodProductRepo.findAll();
    }

    public WoodProduct updateWoodProduct(WoodProductStockRequest stock) {
        WoodProduct woodProduct = this.findWoodProductById(stock.getWoodProductId());
        woodProduct.setQuantityInStock(woodProduct.getQuantityInStock() + stock.getQuantity());
        return this.woodProductRepo.save(woodProduct);
    }

    public WoodProduct findWoodProductById(long id) {
        return this.woodProductRepo.getReferenceById(id);
    }
    public void deleteWoodProduct(long id) {
        this.woodProductRepo.deleteById(id);
    }

}
