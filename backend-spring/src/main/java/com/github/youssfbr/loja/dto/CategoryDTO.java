package com.github.youssfbr.loja.dto;

import com.github.youssfbr.loja.entities.Category;
import lombok.*;

import java.io.Serializable;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public CategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();
    }
}
