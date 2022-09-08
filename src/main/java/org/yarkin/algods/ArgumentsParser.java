package org.yarkin.algods;

import java.util.HashMap;
import java.util.Map;

public class ArgumentsParser {
    private static final String KEY_PREFIX = "-";
    private final Map<String, String> arguments;
    public ArgumentsParser(String[] arguments) {
        this.arguments = parse(arguments);
    }

    public String get(String key) {
        return arguments.get(key);
    }

    private Map<String, String> parse(String[] arguments) {
        Map<String, String> result = new HashMap<>();

        for (int i = 0; i < arguments.length; i++) {
            if (arguments[i].startsWith(KEY_PREFIX)) {
                if (i + 1 < arguments.length && !arguments[i + 1].startsWith(KEY_PREFIX)) {
                    result.put(arguments[i], arguments[i + 1]);
                    continue;
                }
                result.put(arguments[i], "");
            }
        }

        return result;
    }
}
