package org.interpreter.nodes;

import com.fasterxml.jackson.databind.JsonNode;

public class VarNodeInterpreter implements NodeInterpreter {
    @Override
    public void interpret(JsonNode node) {
        node.get("text").asText();
    }
}
