package br.edu.zup.e_commerce.exceptions;

public class ProductOutOfStockException extends IllegalStateException{
    public ProductOutOfStockException(String message) {
        super(message);
    }
}
