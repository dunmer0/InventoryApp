package com.woodhome.stockmanager.repo;

import com.woodhome.stockmanager.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {

}
