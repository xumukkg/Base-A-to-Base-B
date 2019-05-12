package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите значение x:");
        Scanner data = new Scanner(System.in);
        String str1;
        str1 = data.next();
        String str = convertHexToBase36(toHex(str1));
        System.out.println("Значение x в Hex:");
        System.out.println(str);
        String back = convertBase36ToHex(str);
        System.out.println("Значение x в 36-ом исчислении:");
        System.out.println(fromHex(back));

    }

    public static String fromHex(String hex) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hex.length(); i += 2) {
            String str = hex.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output.toString();
    }

    public static String convertHexToBase36(String hex) {
        BigInteger big = new BigInteger(hex, 16);
        StringBuilder sb = new StringBuilder(big.toString(36));
        return sb.reverse().toString();
    }

    public static String convertBase36ToHex(String b36) {
        StringBuilder sb = new StringBuilder(b36);
        BigInteger base = new BigInteger(sb.reverse().toString(), 36);
        return base.toString(16);
    }

    public static String toHex(String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes()));
    }
}
