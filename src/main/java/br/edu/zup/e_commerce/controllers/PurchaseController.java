package br.edu.zup.e_commerce.controllers;

import br.edu.zup.e_commerce.dtos.PurchaseRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/compras")
public class PurchaseController {
    @PutMapping
    public ResponseEntity<String> updatePurchase(@RequestBody @Valid PurchaseRequestDTO purchaseRequestDTO) {
        return ResponseEntity.ok(null);
    }
}
/*
{
  "cpf": "12345678900",
  "produtos": [
    { "nome": "Produto1" },
    { "nome": "Produto2" }
  ]
}
*/
