package com.dogukan.customerorderproject.entity;


import com.dogukan.customerorderproject.dto.OrderDto;
import com.dogukan.customerorderproject.dto.ProdDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="orderr")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
    private Long custId;
    private Long price;
    private Long prodId;
}
