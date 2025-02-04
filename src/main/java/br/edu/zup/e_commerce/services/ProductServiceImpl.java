package br.edu.zup.e_commerce.services;

import br.edu.zup.e_commerce.dtos.ProductRequestDTO;
import br.edu.zup.e_commerce.dtos.ProductResponseDTO;
import br.edu.zup.e_commerce.exceptions.ProductNotFoundException;
import br.edu.zup.e_commerce.mappers.ProductMapper;
import br.edu.zup.e_commerce.models.Product;
import br.edu.zup.e_commerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
        // Teste erro de id(name) repetido
        return ProductMapper.fromEntityToDTO(
                productRepository.save(
                        ProductMapper.fromDTOToEntity(product)
                )
        );
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(ProductMapper::fromEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(String name) {
        Product foundProduct = productRepository.findById(name)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Produto com o nome " + name + " não encontrado."
                        )
                );

        productRepository.delete(foundProduct);
    }
}
