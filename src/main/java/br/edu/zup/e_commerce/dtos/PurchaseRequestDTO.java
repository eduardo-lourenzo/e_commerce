package br.edu.zup.e_commerce.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public class PurchaseRequestDTO {

    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotEmpty(message = "A lista de produtos não pode estar vazia")
    @JsonProperty("produtos") // Mapeia a chave "produtos" do JSON para o atributo "products"
    @Valid
    private List<ProductDTO> products;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(@Valid List<ProductDTO> products) {
        this.products = products;
    }

    public static class ProductDTO {
        @NotBlank(message = "O nome do produto é obrigatório.")
        @JsonProperty("nome")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}