package br.edu.zup.e_commerce.services;

import org.springframework.http.ResponseEntity;

public interface CustomerService {
    ResponseEntity<?> createCustomer(/*Customer customer*/);

    ResponseEntity<?> getCustomerById(String cpf);

    ResponseEntity<?> updateCustomer(String cpf);
}
