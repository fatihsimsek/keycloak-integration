package com.demo.keycloak.port;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class BookCreateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String writerName;
    @NotNull
    private BigDecimal amount;
    @Min(value = 1)
    private Integer stock;
}
