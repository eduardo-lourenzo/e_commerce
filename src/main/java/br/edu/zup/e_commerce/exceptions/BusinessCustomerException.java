package br.edu.zup.e_commerce.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class BusinessCustomerException extends DataIntegrityViolationException {

    public BusinessCustomerException(String message) {
        super(determineMessage(message));
    }

    private static String determineMessage(String message) {
        boolean hasCpfError = message.toLowerCase().contains("cpf");
        boolean hasEmailError = message.toLowerCase().contains("email");

        if (hasCpfError && hasEmailError) {
            return "CPF e email já cadastrados.";
        } else if (hasCpfError) {
            return "CPF já cadastrado.";
        } else if (hasEmailError) {
            return "Email já cadastrado.";
        } else {
            return "Erro nos dados do cliente";
        }
    }
}
