package com.br.estudos.dsdeliever.services;

import com.br.estudos.dsdeliever.dtos.OrderDTO;
import com.br.estudos.dsdeliever.dtos.ProductDTO;
import com.br.estudos.dsdeliever.entities.Order;
import com.br.estudos.dsdeliever.entities.OrderStatus;
import com.br.estudos.dsdeliever.entities.Product;
import com.br.estudos.dsdeliever.repositories.OrderRepository;
import com.br.estudos.dsdeliever.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;


    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        return orderRepository.findOrdersWithProducts()
                .stream().map(product -> new OrderDTO(product))
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO create(OrderDTO orderDTO){
        Order toBeSaved = new Order(null, orderDTO.getAddress(), orderDTO.getLatitude(), orderDTO.getLongitude(),
                Instant.now(), OrderStatus.PENDING);

        for(ProductDTO p : orderDTO.getProducts()){
            Product product = productRepository.getOne(p.getId());
            toBeSaved.getProducts().add(product);
        }

        Order saved = orderRepository.save(toBeSaved);

        return new OrderDTO(saved);
    }

    @Transactional
    public OrderDTO updateStatusDelivered(Long id){
        Order order = orderRepository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        Order saved = orderRepository.save(order);

        return new OrderDTO(saved);

    }
}
