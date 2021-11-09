package com.github.youssfbr.loja.services;

import com.github.youssfbr.loja.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> findAll();
    CategoryDTO findById(Long id);
    CategoryDTO insert(CategoryDTO dto);
    CategoryDTO update(Long id, CategoryDTO dto);
}
