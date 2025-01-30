package br.edu.zup.e_commerce.services;

import br.edu.zup.e_commerce.dtos.CustomerRequestDTO;
import br.edu.zup.e_commerce.dtos.CustomerResponseDTO;
import jakarta.validation.Valid;

public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO getCustomerById(String cpf);

    CustomerResponseDTO updateCustomer(String cpf, CustomerRequestDTO customerRequestDTO);
}
