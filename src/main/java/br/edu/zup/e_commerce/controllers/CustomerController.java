package br.edu.zup.e_commerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class CustomerController {
    @PostMapping
    public ResponseEntity<?> createCustomer(/*RequestBody Customer customer*/) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> getCustomerById(@PathVariable String cpf) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<?> updateCustomer(@PathVariable String cpf) {
        return ResponseEntity.ok(null);
    }
}
