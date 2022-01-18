package com.dogukan.customerorderproject.entity;

import com.dogukan.customerorderproject.dto.CustDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="cust")
public class CustEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long custId;
    private String custName;
    private String email;
    private String password;
}
