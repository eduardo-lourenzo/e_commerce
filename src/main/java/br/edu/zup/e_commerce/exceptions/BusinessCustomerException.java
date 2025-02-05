package br.edu.zup.e_commerce.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class BusinessCustomerException extends DataIntegrityViolationException {

    public BusinessCustomerException(String message) {
        super(message);
    }
}
