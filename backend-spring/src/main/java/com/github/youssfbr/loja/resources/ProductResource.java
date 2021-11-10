package com.github.youssfbr.loja.resources;

import com.github.youssfbr.loja.dto.ProductDTO;
import com.github.youssfbr.loja.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    private final ProductService ProductService;

    public ProductResource(final ProductService ProductService) {
        this.ProductService = ProductService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(ProductService.findAll());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<ProductDTO>> findAllPages(Pageable pageable) {
        return ResponseEntity.ok(ProductService.findAllPaged(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(final @PathVariable Long id) {
        return ResponseEntity.ok(ProductService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto) {

        dto = ProductService.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto) {

        dto = ProductService.update(id, dto);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id) {

        ProductService.delete(id);

        return ResponseEntity.noContent().build();
    }


}
