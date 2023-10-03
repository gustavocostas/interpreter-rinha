package org.interpreter.nodes;

import com.fasterxml.jackson.databind.JsonNode;

import static org.interpreter.Interpreter.isInPrintContext;

public class StrNodeInterpreter implements NodeInterpreter {
    @Override
    public void interpret(JsonNode node) {

        if (isInPrintContext) {
            String value = node.get("value").asText();
            System.out.print(value);
        }
        isInPrintContext = false;
    }
}