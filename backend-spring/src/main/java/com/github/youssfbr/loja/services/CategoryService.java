package com.github.youssfbr.loja.services;

import com.github.youssfbr.loja.dto.CategoryDTO;
import com.github.youssfbr.loja.entities.Category;
import com.github.youssfbr.loja.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService{

    private final ICategoryRepository categoryRepository;

    public CategoryService(final ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = categoryRepository.findAll();
        return list.stream().map(cat -> new CategoryDTO(cat)).collect(Collectors.toList());
    }
}
