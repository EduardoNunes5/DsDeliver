package com.br.estudos.dsdeliever.dtos;

import com.br.estudos.dsdeliever.entities.Order;
import com.br.estudos.dsdeliever.entities.OrderStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {

    private Long id;

    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;

    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO(){

    }

    public OrderDTO(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status, List<ProductDTO> products) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
        this.products = products;
    }

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.address = entity.getAddress();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
        this.moment = entity.getMoment();
        this.status = entity.getStatus();
        this.products = entity.getProducts()
                .stream()
                .map(product -> new ProductDTO(product))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

}
