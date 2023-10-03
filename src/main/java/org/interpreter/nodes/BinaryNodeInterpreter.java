package org.interpreter.nodes;

import com.fasterxml.jackson.databind.JsonNode;

import static org.interpreter.Interpreter.interpreter;

public class BinaryNodeInterpreter implements NodeInterpreter {
    @Override
    public void interpret(JsonNode node) {

        JsonNode lhsNode = node.get("lhs");
        JsonNode opNode = node.get("op");
        JsonNode rhsNode = node.get("rhs");

        if (lhsNode != null && opNode != null && rhsNode != null) {
            interpreter(lhsNode);
            interpreter(rhsNode);

            String operator = opNode.asText();
            if (operator.equals("Add")) {
                if (rhsNode.has("arguments")) {
                    interpretArguments(rhsNode.get("arguments"));
                }
            } else {
                throw new UnsupportedOperationException("Operador desconhecido: " + operator);
            }
        }
    }

    public static void interpretArguments(JsonNode node) {
        if (node.isArray()) {
            for (JsonNode argument : node) {
                if (argument.has("kind")) {
                    interpreter(argument);
                }
            }
        }
    }
}
