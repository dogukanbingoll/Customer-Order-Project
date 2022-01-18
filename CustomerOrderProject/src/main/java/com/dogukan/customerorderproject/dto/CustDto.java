package com.dogukan.customerorderproject.dto;

import com.dogukan.customerorderproject.entity.CustEntity;
import com.dogukan.customerorderproject.entity.ProdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustDto {

    private Long custId;
    private String custName;
    private String email;
    private String password;
}
