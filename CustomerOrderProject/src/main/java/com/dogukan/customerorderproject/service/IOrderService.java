package com.dogukan.customerorderproject.service;

import com.dogukan.customerorderproject.dto.OrderDto;
import com.dogukan.customerorderproject.dto.ProdDto;
import com.dogukan.customerorderproject.entity.OrderEntity;

import java.util.List;

public interface IOrderService {
    OrderEntity createOrder(OrderDto orderDto);
    List<OrderDto> getAllOrder();
    void deleteOrder(Long orderId);
}
