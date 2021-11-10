package com.github.youssfbr.loja.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NonNull@Setter
    private String name;

    @Column(columnDefinition = "TEXT")
    @NonNull@Setter
    private String description;

    @NonNull@Setter
    private Double price;

    @Column(name = "promotion")
    @NonNull@Setter
    private boolean isPromotion;

    @Setter
    private Double promotionPrice;

    @Setter
    private String imgUrl;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @NonNull@Setter
    private Instant date;

    @ManyToMany
    @JoinTable(
            name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

}
