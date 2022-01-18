package com.dogukan.customerorderproject.controller;

import com.dogukan.customerorderproject.dto.OrderDto;
import com.dogukan.customerorderproject.entity.OrderEntity;
import com.dogukan.customerorderproject.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderr")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderDto orderDto){

        return ResponseEntity.ok(this.orderService.createOrder(orderDto));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.ok(this.orderService.getAllOrder());
    }


    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId){
        this.orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order is deleted successfully");
    }
}
