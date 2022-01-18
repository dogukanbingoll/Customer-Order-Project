package com.dogukan.customerorderproject.service.impl;

import com.dogukan.customerorderproject.dto.CustDto;
import com.dogukan.customerorderproject.entity.CustEntity;
import com.dogukan.customerorderproject.maping.CustMapper;
import com.dogukan.customerorderproject.repository.ICustRepository;
import com.dogukan.customerorderproject.service.ICustService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustServiceImpl implements ICustService {

    private final ICustRepository custRepository;

    @Override
    public CustEntity createCust(CustDto custDto) {
       return this.custRepository.save(CustMapper.INSTANCE.toEntity(custDto));
    }

    @Override
    public void updateCust(CustDto newCustDto) {
        this.custRepository.save(CustMapper.INSTANCE.toEntity(newCustDto));
    }

    @Override
    public void deleteCust(Long custId) {
        this.custRepository.deleteById(custId);

    }

    @Override
    public CustDto getCust(Long custId) {
        return this.custRepository
                .findById(custId)
                .map(CustMapper.INSTANCE::toDto)
                .orElse(null);
    }




    @Override
    public List<CustDto> getAllCust() {
        return this.custRepository.findAll().stream()
                    .map(CustMapper.INSTANCE::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public CustDto getCustByEmail(String email) {
        List<CustEntity> custList=this.custRepository.findAll();
        CustEntity ce=new CustEntity();
        for(CustEntity custEntity:custList){
            if(custEntity.getEmail().equals(email)){
                ce=custEntity;
                break;
            }
        }
        CustDto custDto=CustMapper.INSTANCE.toDto(ce);
        return custDto;

    }
}
