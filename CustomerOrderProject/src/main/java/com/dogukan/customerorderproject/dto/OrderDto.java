package com.dogukan.customerorderproject.dto;

import com.dogukan.customerorderproject.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderDto {

    private Long orderId;
    private Long custId;
    private Long price;
    private Long prodId;
}
