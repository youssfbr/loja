package com.github.youssfbr.loja.services;

import com.github.youssfbr.loja.entities.Category;
import com.github.youssfbr.loja.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private final ICategoryRepository categoryRepository;

    public CategoryService(final ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
