package br.edu.zup.e_commerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProductController {
    @PostMapping
    public ResponseEntity<?> createProduct(/*@RequestBody Product product*/) {
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> updateCustomer(@PathVariable String name) {
        return ResponseEntity.ok(null);
    }
}