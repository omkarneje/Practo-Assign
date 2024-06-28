package org.example;

import java.util.*;

// Observer interface




// Main application class
public  class ItemNotificationApp {
    public static void main(String[] args) {
        ItemObservable itemObservable = new ItemObservable();
        CommandProcessor commandProcessor = new CommandProcessor(itemObservable);

        // Simulate user input (you can replace this with actual user input logic)
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command (+item, -item, list, exit, color): ");
            String command = scanner.nextLine();
            commandProcessor.processCommand(command);
        }
    }
}
