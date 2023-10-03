package org.interpreter;

import com.fasterxml.jackson.databind.JsonNode;
import org.interpreter.nodes.*;

public class Interpreter {

    public static boolean isInPrintContext = false;

    public static void interpreter(JsonNode node) {
        String kind = node.get("kind").asText();

        NodeInterpreter nodeInterpreter;

        switch (kind) {
            case "Let" -> nodeInterpreter = new LetNodeInterpreter();
            case "Function" -> nodeInterpreter = new FunctionNodeInterpreter();
            case "Binary" -> nodeInterpreter = new BinaryNodeInterpreter();
            case "Var" -> nodeInterpreter = new VarNodeInterpreter();
            case "Print" -> {
                isInPrintContext = true;
                nodeInterpreter = new PrintNodeInterpreter();
            }
            case "Str" -> nodeInterpreter = new StrNodeInterpreter();
            case "Call" -> nodeInterpreter = new CallNodeInterpreter();
            case "Int" -> nodeInterpreter = new IntNodeInterpreter();
            default -> {
                System.err.println("Unknown Type: " + kind);
                return;
            }
        }

        nodeInterpreter.interpret(node);
    }
}