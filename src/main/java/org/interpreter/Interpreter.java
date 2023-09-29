package org.interpreter;

import com.fasterxml.jackson.databind.JsonNode;

import static org.utils.BinaryOperators.addToNumber;
import static org.utils.BinaryOperators.printNumber;

public class Interpreter {

    private static boolean isInPrintContext = false;

    public static void interpreter(JsonNode node) {
        String kind = node.get("kind").asText();

        switch (kind) {
            case "Let" -> visitLet(node);
            case "Function" -> visitFunction(node);
            case "Binary" -> visitBinary(node);
            case "Var" -> visitVar(node);
            case "Print" -> {
                isInPrintContext = true;
                visitPrint(node);
                isInPrintContext = false;
            }
            case "Str" -> visitStr(node);
            case "Call" -> visitCall(node);
            case "Int" -> visitInt(node);
            default -> System.err.println("Unknown Type: " + kind);
        }
    }

    private static void visitLet(JsonNode node) {

        JsonNode valueNode = node.get("value");
        if (valueNode != null) {
            interpreter(valueNode);
        }
        JsonNode nextNode = node.get("next");
        if (nextNode != null) {
            interpreter(nextNode);
        }
    }

    private static void visitFunction(JsonNode node) {

        JsonNode parametersNode = node.get("parameters");
        if (parametersNode != null) {
            interpretParameters(parametersNode);
        }

        JsonNode valueNode = node.get("value");
        if (valueNode != null) {
            interpreter(valueNode);
        }
    }

    private static void visitBinary(JsonNode node) {

        JsonNode lhsNode = node.get("lhs");
        JsonNode opNode = node.get("op");
        JsonNode rhsNode = node.get("rhs");

        if (lhsNode != null && opNode != null && rhsNode != null) {
            interpreter(lhsNode);
            interpreter(rhsNode);

            if (opNode.asText().equals("Add")) {
                if (rhsNode.has("arguments")) {
                    interpretArguments(rhsNode.get("arguments"));
                }
            }
        }
    }

    private static void visitVar(JsonNode node) {
        node.get("text").asText();
    }

    private static void visitPrint(JsonNode node) {
        JsonNode valueNode = node.get("value");

        if (valueNode != null) {
            interpreter(valueNode);
        }
    }

    private static void visitStr(JsonNode node) {
        if (isInPrintContext) {
            String value = node.get("value").asText();
            System.out.println(value);
        }
    }

    private static void visitCall(JsonNode node) {
        JsonNode calleeNode = node.get("callee");

        if (calleeNode != null) {
            interpreter(calleeNode);
        }
    }

    private static void visitInt(JsonNode node) {
        int valueNode = node.get("value").asInt();

        addToNumber(valueNode);
        if (valueNode > 1) {
            printNumber();
        }
    }

    private static void interpretArguments(JsonNode node) {
        if (node.isArray()) {
            for (JsonNode argument : node) {
                if (argument.has("kind")) {
                    interpreter(argument);
                }
            }
        }
    }

    private static void interpretParameters(JsonNode node) {
        for (JsonNode parameter : node) {
            parameter.get("text").asText();
            return;
        }
    }
}
