package org.interpreter.nodes;

import com.fasterxml.jackson.databind.JsonNode;

import static org.interpreter.Interpreter.interpretParameters;
import static org.interpreter.Interpreter.interpreter;

public class FunctionNodeInterpreter implements NodeInterpreter {
    @Override
    public void interpret(JsonNode node) {

        JsonNode parametersNode = node.get("parameters");
        if (parametersNode != null) {
            interpretParameters(parametersNode);
        }

        JsonNode valueNode = node.get("value");
        if (valueNode != null) {
            interpreter(valueNode);
        }
    }
}
