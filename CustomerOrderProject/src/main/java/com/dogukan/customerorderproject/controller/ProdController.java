package com.dogukan.customerorderproject.controller;

import com.dogukan.customerorderproject.dto.ProdDto;
import com.dogukan.customerorderproject.entity.ProdEntity;
import com.dogukan.customerorderproject.service.IProdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod")
@RequiredArgsConstructor
public class ProdController {
    private final IProdService prodService;

    @PostMapping("/create")
    public ResponseEntity<ProdEntity> createProd(@RequestBody ProdDto prodDto){
        return ResponseEntity.ok(this.prodService.createProd(prodDto));
    }
    @GetMapping("/{prodId}")
    public ResponseEntity<ProdDto> getProd(@PathVariable Long prodId){
        return ResponseEntity.ok(this.prodService.getProd(prodId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProdDto>> getAllProd(){
        return ResponseEntity.ok(this.prodService.getAllProd());
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProd(@RequestBody ProdDto prodDto ){
        this.prodService.updateProd(prodDto);
        return ResponseEntity.ok("Product is updated");
    }
    @DeleteMapping("/{prodId}")
    public ResponseEntity<String> deleteProd(@PathVariable Long prodId){
        this.prodService.deleteProd(prodId);
        return ResponseEntity.ok("Product is deleted");
    }


}
