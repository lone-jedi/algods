package org.yarkin.algods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArgumentsParserTest {

    @Test
    @DisplayName("Get parsed arguments from array")
    public void getParsedArguments() {
        String[] testArguments = {"-n", "Some name", "-x", "-t", "Title", "-d", "Description...", "-f"};

        ArgumentsParser argumentsParser = new ArgumentsParser(testArguments);
        assertEquals("Some name", argumentsParser.get("-n"));
        assertEquals("Title", argumentsParser.get("-t"));
        assertEquals("Description...", argumentsParser.get("-d"));
        assertEquals("", argumentsParser.get("-f"));
        assertEquals("", argumentsParser.get("-x"));
    }
}