package com.br.estudos.dsdeliever.controllers;

import com.br.estudos.dsdeliever.dtos.OrderDTO;
import com.br.estudos.dsdeliever.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }
}
