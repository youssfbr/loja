package com.github.youssfbr.loja.services;

import com.github.youssfbr.loja.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<ProductDTO> findAllPaged(Pageable pageable);
    List<ProductDTO> findAll();
    ProductDTO findById(Long id);
    ProductDTO insert(ProductDTO dto);
    ProductDTO update(Long id, ProductDTO dto);
    void delete(Long id);


}
