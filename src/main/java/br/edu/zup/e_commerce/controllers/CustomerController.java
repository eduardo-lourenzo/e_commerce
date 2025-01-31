package br.edu.zup.e_commerce.controllers;

import br.edu.zup.e_commerce.dtos.CustomerRequestDTO;
import br.edu.zup.e_commerce.dtos.CustomerResponseDTO;
import br.edu.zup.e_commerce.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDTO));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable String cpf) {
        return ResponseEntity.ok(customerService.getCustomerById(cpf));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@PathVariable String cpf,
                                                              @RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(cpf, customerRequestDTO));
    }
}
