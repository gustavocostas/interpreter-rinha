package org.utils;

public class BinaryOperators {
    private static int number = 0;

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        BinaryOperators.number = number;
    }

    public static void addToNumber(int value) {
        int currentNumber = getNumber();
        currentNumber += value;
        setNumber(currentNumber);
    }

    public static void subToNumber(int value) {
        int currentNumber = getNumber();
        currentNumber -= value;
        setNumber(currentNumber);
    }

    public static void printNumber() {
        System.out.println(getNumber());
    }
}
