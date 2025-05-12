package com.marchanddev.urlshortener.core.utils;

import java.math.BigInteger;

public class Base62Encoder {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(byte[] input, int length) {
        BigInteger number = new BigInteger(1, input); // valor sem sinal
        StringBuilder sb = new StringBuilder();

        while (number.compareTo(BigInteger.ZERO) > 0) {
            int remainder = number.mod(BigInteger.valueOf(62)).intValue();
            sb.append(BASE62.charAt(remainder));
            number = number.divide(BigInteger.valueOf(62));
        }

        // Garante tamanho mínimo
        while (sb.length() < length) {
            sb.append('0');
        }

        String result = sb.reverse().toString();
        if (result.length() > length) {
            result = result.substring(0, length);
        }
        return result;
    }
}
