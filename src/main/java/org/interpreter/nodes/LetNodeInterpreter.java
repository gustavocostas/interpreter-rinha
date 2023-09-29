package org.interpreter.nodes;

import com.fasterxml.jackson.databind.JsonNode;

import static org.interpreter.Interpreter.interpreter;

public class LetNodeInterpreter implements NodeInterpreter {
    @Override
    public void interpret(JsonNode node) {

        JsonNode valueNode = node.get("value");
        if (valueNode != null) {
            interpreter(valueNode);
        }

        JsonNode nextNode = node.get("next");
        if (nextNode != null) {
            interpreter(nextNode);
        }
    }
}
