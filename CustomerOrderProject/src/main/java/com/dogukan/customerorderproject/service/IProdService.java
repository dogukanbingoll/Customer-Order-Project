package com.dogukan.customerorderproject.service;

import com.dogukan.customerorderproject.dto.ProdDto;
import com.dogukan.customerorderproject.entity.ProdEntity;

import java.util.List;

public interface IProdService {
    ProdEntity createProd(ProdDto prodDto);
    ProdDto getProd(Long prodId);
    List<ProdDto> getAllProd();
    void updateProd(ProdDto newProdDto);
    void deleteProd(Long prodId);


}
