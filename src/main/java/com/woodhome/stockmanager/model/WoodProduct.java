package com.woodhome.stockmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public  class WoodProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long woodProductId;
    private String name;
    private double thickness;
    private double height;
    private double length;
    private double price;
    private boolean soldByPack;
    private int quantityInStock;




}
