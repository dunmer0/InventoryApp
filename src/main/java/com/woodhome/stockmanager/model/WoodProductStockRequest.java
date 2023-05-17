package com.woodhome.stockmanager.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WoodProductStockRequest {
    private Long woodProductId;
    private int quantity;
}
