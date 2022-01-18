package com.dogukan.customerorderproject.service;

import com.dogukan.customerorderproject.dto.CustDto;
import com.dogukan.customerorderproject.entity.CustEntity;

import java.util.List;

public interface ICustService {
    
    CustEntity createCust(CustDto custDto);
    void updateCust(CustDto newCustDto);
    void deleteCust(Long custId);
    CustDto getCust(Long custId);

    List<CustDto> getAllCust();
    CustDto getCustByEmail(String email);

}
