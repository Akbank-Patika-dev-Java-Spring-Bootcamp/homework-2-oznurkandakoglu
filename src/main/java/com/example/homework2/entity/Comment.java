package com.example.homework2.entity;

import com.example.homework2.general.BaseEntity;
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

    @Column(name = "PRODUCT_ID", length = 100, nullable = false)
    private Long productId;

    @Column(name = "USER_ID", length = 100, nullable = false)
    private Long userId;


}
