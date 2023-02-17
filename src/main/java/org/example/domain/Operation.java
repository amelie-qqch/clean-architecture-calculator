package org.example.domain;

import java.util.ArrayList;

public class Operation {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';

    private final ArrayList<Character> allowedOperations = new ArrayList<>() {{
        add(ADDITION);
        add(SUBTRACTION);
        add(MULTIPLICATION);
    }};

    private final Character operation;

    public Operation(Character operation) {
        if(!allowedOperations.contains(operation)) {
            throw new IllegalArgumentException("Operation " + operation + " is not allowed");
        }

        this.operation = operation;
    }

    public int applyOperation(int number1, int number2) {

        return switch (operation) {
            case ADDITION -> number1 + number2;
            case SUBTRACTION -> number1 - number2;
            case MULTIPLICATION -> number1 * number2;
            default -> 0;
        };
    }
}
