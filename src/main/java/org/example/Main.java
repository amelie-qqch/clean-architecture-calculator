package org.example;

import org.example.domain.Operation;
import org.example.infrastructure.FileParser;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static String FILE_NAME = "number.txt";
    public static String OPERATION = "+";

    public static void main(String[] args) {
        FileParser fileParser = new FileParser();

        ArrayList<String> lines = fileParser.parseFile(FILE_NAME);

        ArrayList<Integer> numbers = lines
            .stream()
            .map(Integer::parseInt)
            .collect(Collectors.toCollection(ArrayList::new)
        );

        Operation operationObject = new Operation(OPERATION.charAt(0));
        int result = 0;

        for (int number : numbers) {
            result = operationObject.applyOperation(result, number);
        }

        System.out.println("Result = " + result);
    }
}