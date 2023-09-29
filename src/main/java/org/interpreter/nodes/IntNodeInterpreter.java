package org.interpreter.nodes;

import com.fasterxml.jackson.databind.JsonNode;

import static org.utils.BinaryOperators.addToNumber;
import static org.utils.BinaryOperators.printNumber;

public class IntNodeInterpreter implements NodeInterpreter {
    @Override
    public void interpret(JsonNode node) {

        int valueNode = node.get("value").asInt();

        addToNumber(valueNode);
        if (valueNode > 1) {
            printNumber();
        }
    }
}
