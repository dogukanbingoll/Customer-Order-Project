package com.dogukan.customerorderproject.service.impl;

import com.dogukan.customerorderproject.dto.ProdDto;
import com.dogukan.customerorderproject.entity.ProdEntity;
import com.dogukan.customerorderproject.maping.ProdMapper;
import com.dogukan.customerorderproject.repository.IProdReposity;
import com.dogukan.customerorderproject.service.IProdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdServiceImpl implements IProdService {

    private final IProdReposity prodReposity;

    @Override
    public ProdEntity createProd(ProdDto prodDto) {
        return this.prodReposity.save(ProdMapper.INSTANCE.toEntity(prodDto));
    }

    @Override
    public ProdDto getProd(Long prodId) {
        return this.prodReposity.findById(prodId)
                .map(ProdMapper.INSTANCE::toDto)
                .orElse(null);
    }

    @Override
    public List<ProdDto> getAllProd() {
        return this.prodReposity.findAll().stream()
                .map(ProdMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateProd(ProdDto newProdDto) {
        this.prodReposity.save(ProdMapper.INSTANCE.toEntity(newProdDto));
    }

    @Override
    public void deleteProd(Long prodId) {
        this.prodReposity.deleteById(prodId);
    }



}
