package com.demo.keycloak.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BookDto {
    private String id;
    private String name;
    private String writerName;
    private BigDecimal amount;
}
