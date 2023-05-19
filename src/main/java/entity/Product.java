package entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private Integer price;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Comment> comments;

}
