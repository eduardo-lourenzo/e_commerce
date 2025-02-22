package br.edu.zup.e_commerce.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductRequestDTO {
    @NotBlank(message = "O nome do produto é obrigatório.")
    private String name;

    @NotNull(message = "O preço do produto é obrigatório.")
    @Positive(message = "O preço do produto deve ser maior que zero.")
    private Double price;

    @NotNull(message = "A quantidade do produto é obrigatória.")
    @Min(value = 0, message = "A quantidade do produto deve ser maior ou igual a zero.")
    private int quantity;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String name, Double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
