package com.thafonsotest.users_api.validations;


public class CpfValidator {

    public static boolean isValid(String cpf) {
        cpf = cpf.replaceAll("[^0-9]",""); // remove .-, let just numbers

        if (cpf == null || cpf.length() != 11) return false;
        if (cpf.matches("(\\d)\\1{10}")) return false; // (\\d) -> get a number and \\1{10} -> repeat the same number 10x

        try {
            int soma = 0;
            int digito = 10;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * digito;
            }
            int dig1 = (soma * 10) % 11;
            if (dig1 == 10) dig1 = 0;

            soma = 0;
            digito = 11;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * digito;
            }

            int dig2 = (soma * 10) % 11;
            if (dig2 == 10) dig2 = 0;

            return dig1 == (cpf.charAt(9) - '0') && dig2 == (cpf.charAt(10) - '0');

        } catch (Exception e) {
            return false;
        }

    }

}
