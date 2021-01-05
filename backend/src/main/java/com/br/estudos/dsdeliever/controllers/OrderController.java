package com.br.estudos.dsdeliever.controllers;

import com.br.estudos.dsdeliever.dtos.OrderDTO;
import com.br.estudos.dsdeliever.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO orderDTO) {

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(orderDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(orderService.create(orderDTO));
    }

    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrderDTO> updateStatusDelivered(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.updateStatusDelivered(id));
    }
}
