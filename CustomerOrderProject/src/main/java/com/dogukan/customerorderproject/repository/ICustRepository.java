package com.dogukan.customerorderproject.repository;

import com.dogukan.customerorderproject.dto.CustDto;
import com.dogukan.customerorderproject.entity.CustEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.OptionalInt;


@Repository
public interface ICustRepository extends JpaRepository<CustEntity,Long> {
///CutEntity döner,dönüşüm yap
    CustDto findByEmail (String email);
}
