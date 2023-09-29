package org.interpreter.nodes;

import com.fasterxml.jackson.databind.JsonNode;

import static org.interpreter.Interpreter.interpreter;

public class CallNodeInterpreter implements NodeInterpreter {
    @Override
    public void interpret(JsonNode node) {

        JsonNode calleeNode = node.get("callee");

        if (calleeNode != null) {
            interpreter(calleeNode);
        }
    }
}
