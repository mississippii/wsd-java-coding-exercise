package com.solvians.showcase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ISINGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random random = new Random();


    public static String generateISIN(){
        String str= generateUppercase()+generateAlphanumeric(9);
        return str+ calculateCheckDigit(str);
    }

    private static String generateUppercase(){
        Random random = new Random();
        char firstChar = (char) ('A' + random.nextInt(26));
        char secondChar = (char) ('A' + random.nextInt(26));
        return firstChar +String.valueOf(secondChar);
    }

    private static String generateAlphanumeric(int length){
        StringBuilder isin = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int id = random.nextInt(CHARACTERS.length());
            isin.append(CHARACTERS.charAt(id));
        }
        return isin.toString();
    }

    private static int calculateCheckDigit(String input){
        List<Integer> digits = new ArrayList<>();
        for(char c : input.toCharArray()){
            if(Character.isLetter(c)){
                int val= c-'A'+10;
                digits.add(val/10);
                digits.add(val%10);
            }else{
                digits.add(Character.getNumericValue(c));
            }
        }
        int sum = 0;
        Collections.reverse(digits);
        for(int i = 0; i < digits.size(); i++){
            if(digits.get(i)%2 == 0){
                int product = digits.get(i) * 2;
                sum += (product / 10) + (product % 10);
            }else{
                sum += digits.get(i);
            }
        }
        return (10 - (sum % 10)) % 10;
    }
}

