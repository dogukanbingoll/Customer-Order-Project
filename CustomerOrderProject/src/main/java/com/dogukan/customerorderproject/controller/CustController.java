package com.dogukan.customerorderproject.controller;

import com.dogukan.customerorderproject.dto.CustDto;
import com.dogukan.customerorderproject.entity.CustEntity;
import com.dogukan.customerorderproject.service.ICustService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cust")
@RequiredArgsConstructor
public class CustController {

    private final ICustService custService;

    @PostMapping("/create")
    public ResponseEntity<CustEntity> createCustomer(@RequestBody CustDto custDto){
        return ResponseEntity.ok(this.custService.createCust(custDto));
    }



    @GetMapping("/getAll")
    public ResponseEntity<List<CustDto>> getAllCust(){
        return ResponseEntity.ok(this.custService.getAllCust());
    }

    @DeleteMapping("/{custId}")
    public ResponseEntity<String> deleteCust(@PathVariable Long custId){
        this.custService.deleteCust(custId);
        return ResponseEntity.ok("Cust is deleted");
    }
   @PutMapping("/update")
    public ResponseEntity<String> updateCust(@RequestBody CustDto newCustDto){
        this.custService.updateCust(newCustDto);
        return ResponseEntity.ok("Customer is updated!!");
    }

    @GetMapping("/{email}")
    public ResponseEntity<CustDto> getCustByEmail(@PathVariable String email){
        return ResponseEntity.ok(this.custService.getCustByEmail(email));
    }







}
