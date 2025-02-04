package br.edu.zup.e_commerce.exceptions;

import java.util.NoSuchElementException;

public class CustomerNotFoundException extends NoSuchElementException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
