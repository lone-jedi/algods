package org.yarkin.algods;

public class Main {
    public static void main(String[] args) {
        ArgumentsParser argumentsParser = new ArgumentsParser(args);
        String taskName = argumentsParser.get("-t");

        Task task = TaskFactory.getInstance(taskName);
        task.run();
    }
}
