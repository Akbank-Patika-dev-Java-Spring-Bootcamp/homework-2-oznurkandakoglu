package com.example.homework2.entity;
import com.example.homework2.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Product", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
    private Long id;

    @NotBlank
    @Column(name = "PRODUCT_NAME", length = 300, nullable = false)
    private String productName;

    @Column(name = "PRICE", nullable = false)
    private Double price;


}
