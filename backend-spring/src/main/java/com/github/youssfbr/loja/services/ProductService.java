package com.github.youssfbr.loja.services;

import com.github.youssfbr.loja.dto.ProductDTO;
import com.github.youssfbr.loja.entities.Product;
import com.github.youssfbr.loja.repositories.IProductRepository;
import com.github.youssfbr.loja.services.exceptions.DatabaseException;
import com.github.youssfbr.loja.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{

    private final IProductRepository ProductRepository;

    public ProductService(final IProductRepository ProductRepository) {
        this.ProductRepository = ProductRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(Pageable pageable) {
        Page<Product> page = ProductRepository.findAll(pageable);
        return page.map(ProductDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> list = ProductRepository.findAll();
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO findById(final Long id) {
        Product entity = ProductRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso com id: " + id + " não encontrado.", HttpStatus.NOT_FOUND));
        return new ProductDTO(entity, entity.getCategories());
    }

    @Override
    @Transactional
    public ProductDTO insert(ProductDTO dto) {

        Product entity = new Product();
        entity.setName(dto.getName());
        entity = ProductRepository.save(entity);

        return new ProductDTO(entity);
    }

    @Override
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {

        Product entity = ProductRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso com id: " + id + " não encontrado.", HttpStatus.NOT_FOUND));

        entity.setName(dto.getName());
        entity = ProductRepository.save(entity);

        return new ProductDTO(entity);
    }

    @Override
    public void delete(Long id) {
        try {
            ProductRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso com id: " + id + " não encontrado.", HttpStatus.NOT_FOUND);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Recurso não deletado. Violação de integidade",
                    HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            throw new ResourceNotFoundException("Erro interno. Contate o suporte", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
