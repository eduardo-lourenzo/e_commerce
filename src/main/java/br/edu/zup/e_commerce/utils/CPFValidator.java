package br.edu.zup.e_commerce.utils;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CPFValidator {
    private CPFValidator() {
    }

    public static boolean isValidCPF(
            @NotBlank(message = "O CPF é obrigatório.")
            @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos.")
            String cpf
    ) {
        int firstVerifierDigit = getDigitAt(cpf, 9);
        int secondVerifierDigit = getDigitAt(cpf, 10);

        // && Operador AND com curto-circuito (não testa a segunda parte, se a primeira for falsa).
        return isValidVerifierDigit(cpf, 9, firstVerifierDigit)
                && isValidVerifierDigit(cpf, 10, secondVerifierDigit);
    }

    private static int getDigitAt(String cpf, int position) {
        return Character.getNumericValue(cpf.charAt(position));
    }

    private static int getSum(String partialCPF) {
        int sum = 0;
        int factor = partialCPF.length() + 1;

        for (int index = 0; index < partialCPF.length(); index++) {
            sum += factor * getDigitAt(partialCPF, index);
            factor--;
        }

        return sum;
    }

    private static int modulusEleven(int sum) {
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

    private static boolean isValidVerifierDigit(String cpf, int length, int verifierDigit) {
        int calculatedDigit = modulusEleven(getSum(cpf.substring(0, length)));
        return calculatedDigit == verifierDigit;
    }
    /*
    List<String> invalidCpfList = Arrays.asList(
            "00000000000",
            "11111111111",
            "22222222222",
            "33333333333",
            "44444444444",
            "55555555555",
            "66666666666",
            "77777777777",
            "88888888888",
            "99999999999"
    );
    */
}