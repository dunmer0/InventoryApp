package com.woodhome.stockmanager.repo;

import com.woodhome.stockmanager.model.SoldItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SoldItemRepo extends JpaRepository<SoldItem, Long> {

    List<SoldItem> getSoldItemsByCartCartId (long cartId);
}
