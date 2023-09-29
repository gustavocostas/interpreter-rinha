package org.interpreter.nodes;

import com.fasterxml.jackson.databind.JsonNode;

public interface NodeInterpreter {
    void interpret(JsonNode node);
}
