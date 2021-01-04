package com.br.estudos.dsdeliever.services;

import com.br.estudos.dsdeliever.dtos.ProductDTO;
import com.br.estudos.dsdeliever.entities.Product;
import com.br.estudos.dsdeliever.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findAll(){
        return productRepository.findAllByOrderByNameAsc()
                .stream().map(product -> new ProductDTO(product))
                .collect(Collectors.toList());
    }
}
