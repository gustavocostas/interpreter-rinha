package org.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import static org.interpreter.Interpreter.interpreter;

public class Main {
    public static void main(String[] args) {
        String filePath = "soma.rinha.json";

        try {
            JsonNode rootNode = parseJsonFile(filePath);
            JsonNode expressionNode = rootNode.get("expression");

            interpreter(expressionNode);
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error interpreting the expression: " + e.getMessage());
        }
    }

    public static JsonNode parseJsonFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(new File(filePath));
    }
}