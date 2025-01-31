package br.edu.zup.e_commerce.controllers;

import br.edu.zup.e_commerce.dtos.CustomerRequestDTO;
import br.edu.zup.e_commerce.dtos.CustomerResponseDTO;
import br.edu.zup.e_commerce.services.CustomerService;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/clientes")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(
            @RequestBody
            @Valid
            CustomerRequestDTO customerRequestDTO
    ) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDTO));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDTO> getCustomerByCpf(
            @PathVariable
            @CPF(message = "CPF inválido.")
            String cpf
    ) {
        return ResponseEntity.ok(customerService.getCustomerByCpf(cpf));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(
            @PathVariable
            @CPF(message = "CPF inválido.")
            String cpf,
            @RequestBody
            @Valid
            CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(cpf, customerRequestDTO));
    }
}
