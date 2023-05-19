package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import general.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COMMENT")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Comment", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    private Long id;

    @Column(name = "COMMENT_BODY", length = 300)
    private String commentBody;

    @ManyToOne
    @JsonIgnoreProperties(value = { "comments" })
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonIgnoreProperties(value = { "comments" })
    private User user;
}
