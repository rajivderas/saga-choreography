package com.rajivderas.saga.order.controller;

import com.rajivderas.saga.commons.dto.OrderRequestDto;
import com.rajivderas.saga.order.entity.PurchaseOrder;
import com.rajivderas.saga.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public PurchaseOrder createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.createOrder(orderRequestDto);

    }

    @GetMapping
    public List<PurchaseOrder> getAllOrders() {
        return orderService.getAllOrders();
    }
}
