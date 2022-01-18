package com.dogukan.customerorderproject.repository;

import com.dogukan.customerorderproject.entity.ProdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProdReposity extends JpaRepository<ProdEntity,Long> {
}
