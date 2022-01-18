package com.dogukan.customerorderproject.dto;

import com.dogukan.customerorderproject.entity.CustEntity;
import com.dogukan.customerorderproject.entity.ProdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdDto {
    private Long prodId;
    private String prodName;
    private Long prodPrice;
}
