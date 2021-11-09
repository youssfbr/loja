package com.github.youssfbr.loja.services;

import com.github.youssfbr.loja.dto.CategoryDTO;
import com.github.youssfbr.loja.entities.Category;
import com.github.youssfbr.loja.repositories.ICategoryRepository;
import com.github.youssfbr.loja.services.exceptions.ResourceNotFoundException;
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
        return list.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDTO findById(final Long id) {
        Category entity = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso com id: " + id + " não encontrado."));
        return new CategoryDTO(entity);
    }

    @Override
    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {

        Category entity = new Category();
        entity.setName(dto.getName());
        entity = categoryRepository.save(entity);

        return new CategoryDTO(entity);
    }
}
