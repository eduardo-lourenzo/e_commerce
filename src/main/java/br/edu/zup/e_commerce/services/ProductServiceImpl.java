package br.edu.zup.e_commerce.services;

import br.edu.zup.e_commerce.dtos.ProductRequestDTO;
import br.edu.zup.e_commerce.dtos.ProductResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public void deleteProduct(String name) {

    }
}
