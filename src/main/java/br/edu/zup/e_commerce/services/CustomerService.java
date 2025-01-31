package br.edu.zup.e_commerce.services;

import br.edu.zup.e_commerce.dtos.CustomerRequestDTO;
import br.edu.zup.e_commerce.dtos.CustomerResponseDTO;

public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO getCustomerByCpf(String cpf);

    CustomerResponseDTO updateCustomer(String cpf, CustomerRequestDTO customerRequestDTO);
}
