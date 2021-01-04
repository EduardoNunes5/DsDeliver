package com.br.estudos.dsdeliever.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.estudos.dsdeliever.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
