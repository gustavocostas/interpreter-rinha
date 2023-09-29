package org.utils;

import lombok.Getter;

public class BinaryOperators {
    @Getter
    private static int number = 0;

    public static void setNumber(int number) {
        BinaryOperators.number = number;
    }

    public static void addToNumber(int value) {
        int currentNumber = getNumber();
        currentNumber += value;
        setNumber(currentNumber);
    }

    public static void printNumber() {
        System.out.println(getNumber());
    }
}
