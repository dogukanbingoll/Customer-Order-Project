package com.dogukan.customerorderproject.service.impl;

import com.dogukan.customerorderproject.dto.CustDto;
import com.dogukan.customerorderproject.dto.OrderDto;
import com.dogukan.customerorderproject.dto.ProdDto;
import com.dogukan.customerorderproject.entity.CustEntity;
import com.dogukan.customerorderproject.entity.OrderEntity;
import com.dogukan.customerorderproject.entity.ProdEntity;
import com.dogukan.customerorderproject.maping.OrderMapper;
import com.dogukan.customerorderproject.repository.IOrderRepository;
import com.dogukan.customerorderproject.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {
    private final ProdServiceImpl prodService;
    private final CustServiceImpl custService;
    private final IOrderRepository orderRepository;


    @Override
    public void deleteOrder(Long orderId) {
        this.orderRepository.deleteById(orderId);

    }

    public OrderService(ProdServiceImpl prodService, CustServiceImpl custService, IOrderRepository orderRepository) {
        this.prodService = prodService;
        this.custService = custService;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderEntity createOrder(OrderDto orderDto){
      return this.orderRepository.save(OrderMapper.INSTANCE.toEntity(orderDto));
    }

    @Override
    public List<OrderDto> getAllOrder() {
        return this.orderRepository.findAll().
                stream().map(OrderMapper.INSTANCE::toDto).
                collect(Collectors.toList());
    }
}
