package br.edu.zup.e_commerce.services;

import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> createProduct(/*Product product*/);

    ResponseEntity<?> getAllProducts();

    ResponseEntity<?> updateCustomer(String name);
}
