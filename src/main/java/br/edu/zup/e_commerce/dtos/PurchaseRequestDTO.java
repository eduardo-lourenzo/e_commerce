package br.edu.zup.e_commerce.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public class PurchaseRequestDTO {

    @CPF(message = "CPF inválido")
    private String cpf;

    @NotEmpty(message = "A lista de produtos não pode estar vazia")
    @JsonProperty("produtos") // Mapeia a chave "produtos" do JSON para o atributo "products"
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

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public static class ProductDTO {
        @NotEmpty(message = "O nome do produto não pode estar vazio")
        private String nome;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}