package br.edu.zup.e_commerce.mappers;

import br.edu.zup.e_commerce.dtos.CustomerRequestDTO;
import br.edu.zup.e_commerce.dtos.CustomerResponseDTO;
import br.edu.zup.e_commerce.models.Customer;

public class CustomerMapper {
    private CustomerMapper() {
        throw new UnsupportedOperationException("Esta é uma classe mapeadora e não pode ser instanciada");
    }

    public static Customer fromDTOToEntity(CustomerRequestDTO requestDTO){
        return new Customer(
                null,
                requestDTO.getCpf(),
                requestDTO.getName(),
                requestDTO.getEmail()
        );
    }

    public static CustomerResponseDTO fromEntityToDTO(Customer entity){
        return new CustomerResponseDTO(
                entity.getId(),
                entity.getCpf(),
                entity.getName(),
                entity.getEmail()
        );
    }
}
