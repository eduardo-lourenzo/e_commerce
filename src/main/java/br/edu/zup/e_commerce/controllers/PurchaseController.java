package br.edu.zup.e_commerce.controllers;

import br.edu.zup.e_commerce.dtos.PurchaseRequestDTO;
import br.edu.zup.e_commerce.services.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/compras")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> updatePurchase(@Valid @RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        return ResponseEntity.ok(purchaseService.updatePurchase(purchaseRequestDTO));
    }
}