package com.dogukan.customerorderproject.entity;


import com.dogukan.customerorderproject.dto.CustDto;
import com.dogukan.customerorderproject.dto.ProdDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="prod")
@Entity
public class ProdEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long prodId;
    private String prodName;
    private Long prodPrice;
}
