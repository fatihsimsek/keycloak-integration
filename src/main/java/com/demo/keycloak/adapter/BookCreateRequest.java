package com.demo.keycloak.adapter;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookCreateRequest {
    private String name;
    private String writerName;
    private BigDecimal amount;
    private Integer stock;
}
