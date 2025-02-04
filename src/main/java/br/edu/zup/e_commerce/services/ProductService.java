package br.edu.zup.e_commerce.services;

import br.edu.zup.e_commerce.dtos.ProductRequestDTO;
import br.edu.zup.e_commerce.dtos.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO product);

    List<ProductResponseDTO> getAllProducts();

    void deleteProduct(String name);
}
