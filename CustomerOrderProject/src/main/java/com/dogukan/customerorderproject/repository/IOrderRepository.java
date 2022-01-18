package com.dogukan.customerorderproject.repository;

import com.dogukan.customerorderproject.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity,Long> {

}
