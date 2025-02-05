package br.edu.zup.e_commerce.services;

import br.edu.zup.e_commerce.dtos.PurchaseRequestDTO;

import java.util.Map;

public interface PurchaseService {
    Map<String, String> updatePurchase(PurchaseRequestDTO purchaseRequestDT);
}
