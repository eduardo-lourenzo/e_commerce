package br.edu.zup.e_commerce.services;

import br.edu.zup.e_commerce.dtos.PurchaseRequestDTO;
import br.edu.zup.e_commerce.exceptions.CustomerNotFoundException;
import br.edu.zup.e_commerce.exceptions.ProductNotFoundException;
import br.edu.zup.e_commerce.exceptions.ProductOutOfStockException;
import br.edu.zup.e_commerce.models.Customer;
import br.edu.zup.e_commerce.models.Product;
import br.edu.zup.e_commerce.repositories.CustomerRepository;
import br.edu.zup.e_commerce.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public PurchaseServiceImpl(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Map<String, String> updatePurchase(@Valid PurchaseRequestDTO purchaseRequestDTO) {
        Customer foundCustomer = getCustomer(purchaseRequestDTO.getCpf());
        List<Product> foundProducts = productsAllFound(purchaseRequestDTO.getProducts());
        foundProducts.forEach(product -> {
            product.setQuantity(product.getQuantity() - 1);
            productRepository.save(product);
        });
        return Map.of("sucesso", "Todos os produtos comprados");

    }

    private Customer getCustomer(String cpf) {
        return customerRepository.findByCpf(cpf).orElseThrow(() ->
                new CustomerNotFoundException("Cliente com CPF " + cpf + " não foi encontrado.")
        );
    }

    private List<Product> productsAllFound(List<PurchaseRequestDTO.ProductDTO> products) {
        List<Product> foundProducts = new ArrayList<>();
        products.forEach(product ->
                {
                    Product foundProduct = productRepository.findById(product.getName()).orElseThrow(() ->
                            new ProductNotFoundException(
                                    "Produto com o nome " + product.getName() + " não encontrado."
                            )
                    );
                    if (foundProduct.getQuantity() == 0) {
                        throw new ProductOutOfStockException("Produto em falta: " + foundProduct.getName() + ".");
                    }
                    foundProducts.add(foundProduct);
                }
        );

        return foundProducts;
    }
}
