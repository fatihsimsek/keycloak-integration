package com.demo.keycloak.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="book")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String id;
    private String name;

    @Column(name="writerName")
    private String writerName;

    private BigDecimal amount;

    private Integer stock;

    @Column(name="createDate")
    private LocalDateTime createDate;
}
