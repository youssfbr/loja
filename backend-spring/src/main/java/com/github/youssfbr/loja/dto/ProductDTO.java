package com.github.youssfbr.loja.dto;

import com.github.youssfbr.loja.entities.Category;
import com.github.youssfbr.loja.entities.Product;
import lombok.*;

import java.io.Serializable;
//import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
    private boolean promotion;
    private Double promotionPrice;
    private String imgUrl;
    //private Instant date;
    private String description;

    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        promotion = entity.isPromotion();
        promotionPrice = entity.getPromotionPrice();
        imgUrl = entity.getImgUrl();
        //date = entity.getDate();
        description = entity.getDescription();
    }

    public ProductDTO(Product entity, Set<Category> categories) {
        this(entity);
        categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
    }

}
