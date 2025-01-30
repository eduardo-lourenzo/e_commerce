package br.edu.zup.e_commerce.controllers;

import br.edu.zup.e_commerce.dtos.ProductRequestDTO;
import br.edu.zup.e_commerce.dtos.ProductResponseDTO;
import br.edu.zup.e_commerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    private final ProductService productService;

    // @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> delateProduct(@PathVariable String name) {
        productService.deleteProduct(name);
        return ResponseEntity.noContent().build();
    }
}