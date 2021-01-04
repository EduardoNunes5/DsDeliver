package com.br.estudos.dsdeliever.services;

import com.br.estudos.dsdeliever.dtos.OrderDTO;
import com.br.estudos.dsdeliever.dtos.ProductDTO;
import com.br.estudos.dsdeliever.repositories.OrderRepository;
import com.br.estudos.dsdeliever.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        return orderRepository.findOrdersWithProducts()
                .stream().map(product -> new OrderDTO(product))
                .collect(Collectors.toList());
    }
}
