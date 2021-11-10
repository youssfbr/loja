package com.github.youssfbr.loja.services;

import com.github.youssfbr.loja.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<CategoryDTO> findAllPaged(Pageable pageable);
    List<CategoryDTO> findAll();
    CategoryDTO findById(Long id);
    CategoryDTO insert(CategoryDTO dto);
    CategoryDTO update(Long id, CategoryDTO dto);
    void delete(Long id);


}
