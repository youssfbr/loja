package com.github.youssfbr.loja.services;

import com.github.youssfbr.loja.dto.CategoryDTO;
import com.github.youssfbr.loja.dto.ProductDTO;
import com.github.youssfbr.loja.entities.Category;
import com.github.youssfbr.loja.entities.Product;
import com.github.youssfbr.loja.repositories.ICategoryRepository;
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
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{

    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;

    private static final String MESSAGE_ID = "Recurso não encontrado. Id: ";

    public ProductService(final IProductRepository productRepository, final ICategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(final Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);

        return page.map(prod -> new ProductDTO(prod, prod.getCategories()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> list = productRepository.findAll();

        return list.stream().map(prod -> new ProductDTO(prod, prod.getCategories()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO findById(final Long id) {
        Product entity = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE_ID + id, HttpStatus.NOT_FOUND));

        return new ProductDTO(entity, entity.getCategories());
    }

    @Override
    @Transactional
    public ProductDTO insert(final ProductDTO dto) {

        Product entity = new Product();

        copyDtoToEntity(dto, entity);
        entity = productRepository.save(entity);

        return new ProductDTO(entity, entity.getCategories());
    }

    @Override
    @Transactional
    public ProductDTO update(final Long id, final ProductDTO dto) {

        return productRepository.findById(id)
                .map(entity -> {
                    copyDtoToEntity(dto, entity);

                    return new ProductDTO(entity, entity.getCategories());
                })
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE_ID + id,
                        HttpStatus.NOT_FOUND));
    }

    @Override
    public void delete(final Long id) {
        try {
            productRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(MESSAGE_ID + id, HttpStatus.NOT_FOUND);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Recurso não deletado. Violação de integidade",
                    HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            throw new ResourceNotFoundException("Erro interno. Contate o suporte", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean validateDto(final Object object) {
        return Objects.nonNull(object) && !object.toString().isEmpty();
    }

    private Product copyDtoToEntity(final ProductDTO dto, final Product entity) {

        entity.setName(validateDto(dto.getName()) ? dto.getName() : entity.getName());
        entity.setDescription(validateDto(dto.getDescription()) ? dto.getDescription() : entity.getDescription());
        entity.setPrice(validateDto(dto.getPrice()) ? dto.getPrice() : entity.getPrice());
        entity.setPromotion(validateDto(dto.isPromotion()) ? dto.isPromotion() : entity.isPromotion());
        entity.setPromotionPrice(validateDto(dto.getPromotionPrice()) ? dto.getPromotionPrice() : entity.getPromotionPrice());
        entity.setImgUrl(validateDto(dto.getImgUrl()) ? dto.getImgUrl() : entity.getImgUrl());
        entity.setDate(validateDto(dto.getDate()) ? dto.getDate() : entity.getDate());

        entity.getCategories().clear();

        for (CategoryDTO catDto : dto.getCategories()) {

            Optional<Category> category = categoryRepository.findById(catDto.getId());
            if (category.isPresent()) {
                entity.getCategories().add(category.get());
            }
        }

        return entity;
    }

}
