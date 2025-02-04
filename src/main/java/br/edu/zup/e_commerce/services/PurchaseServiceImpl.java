package br.edu.zup.e_commerce.services;

import br.edu.zup.e_commerce.dtos.PurchaseRequestDTO;
import br.edu.zup.e_commerce.models.Customer;
import br.edu.zup.e_commerce.models.Product;
import br.edu.zup.e_commerce.repositories.CustomerRepository;
import br.edu.zup.e_commerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public PurchaseServiceImpl(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Map<String, String> updatePurchase(PurchaseRequestDTO purchaseRequestDTO) {
        Customer foundCustomer = getCustomer(purchaseRequestDTO.getCpf());
        List<Product> foundProducts = productsAllFound(purchaseRequestDTO.getProducts());
        foundProducts.forEach(product -> {
            product.setQuantity(product.getQuantity() - 1);
            productRepository.save(product);
        });
        return Map.of("sucesso", "Todos os produtos comprados");

    }

    private Customer getCustomer(String cpf) {
        // Validar CPF
        return customerRepository.findByCpf(cpf).orElseThrow(() ->
                new NoSuchElementException("Cliente com CPF " + cpf + " não foi encontrado.")
        );
        // CustomerNotFoundException("Cliente com CPF " + cpf + " não foi encontrado.")
    }

    private List<Product> productsAllFound(List<PurchaseRequestDTO.ProductDTO> products) {
        List<Product> foundProducts = new ArrayList<>();
        products.forEach(product ->
                {
                    Product foundProduct = productRepository.findById(product.getNome()).orElseThrow(() ->
                            new RuntimeException(
                                    "Produto com o nome " + product.getNome() + " não encontrado."
                            )
                    );
                    // new ProductNotFoundException("Produto com o nome '" + product.get("nome") + "' não encontrado."));
                    if (foundProduct.getQuantity() == 0) {
                        throw new RuntimeException("Produto " + foundProduct.getName() + " em falta no estoque");
                        // throw new ProductOutStockException("Produto " + foundProduct.getName() + " em falta no estoque");
                        // create Map "Produto em falta: [nome do produto]"
                    }
                    foundProducts.add(foundProduct);
                }
        );

        return foundProducts;
    }
}
