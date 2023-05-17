package com.woodhome.stockmanager.service;

import com.woodhome.stockmanager.model.SoldItem;
import com.woodhome.stockmanager.model.WoodProduct;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISoldItemService {


    SoldItem addSoldItem(long cardId, WoodProduct woodProduct);

    SoldItem updateSoldItem(SoldItem soldItem);

    List<SoldItem> findAllSoldItems(long transactionId);

    SoldItem findById(long cardId, long soldItemId);
}
