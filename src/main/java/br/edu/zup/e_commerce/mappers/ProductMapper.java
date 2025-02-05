package br.edu.zup.e_commerce.mappers;

import br.edu.zup.e_commerce.dtos.ProductRequestDTO;
import br.edu.zup.e_commerce.dtos.ProductResponseDTO;
import br.edu.zup.e_commerce.models.Product;

public class ProductMapper {
    private ProductMapper() {
        throw new UnsupportedOperationException("Esta é uma classe mapeadora e não pode ser instanciada");
    }

    public static Product fromDTOToEntity(ProductRequestDTO requestDTO) {
        return new Product(
                requestDTO.getName(),
                requestDTO.getPrice(),
                requestDTO.getQuantity()
        );
    }

    public static ProductResponseDTO fromEntityToDTO(Product entity) {
        return new ProductResponseDTO(
                entity.getName(),
                entity.getPrice(),
                entity.getQuantity()
        );
    }
}
