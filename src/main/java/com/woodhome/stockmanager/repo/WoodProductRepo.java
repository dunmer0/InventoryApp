package com.woodhome.stockmanager.repo;

import com.woodhome.stockmanager.model.WoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WoodProductRepo extends JpaRepository<WoodProduct, Long> {
}

