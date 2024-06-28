package org.example;

class CommandProcessor {
    private ItemObservable itemObservable;

    public CommandProcessor(ItemObservable itemObservable) {
        this.itemObservable = itemObservable;
    }

    public void processCommand(String command) {
        String[] tokens = command.trim().split(" ");
        switch (tokens[0]) {
            case "+":
                if (tokens.length < 2) {
                    System.out.println("Invalid command format. Example: +item");
                    break;
                }
                String itemToAdd = tokens[1];
                itemObservable.subscribe(itemToAdd, new ItemObserver(itemToAdd));
                System.out.println("Subscribed to " + itemToAdd);
                break;
            case "-":
                if (tokens.length < 2) {
                    System.out.println("Invalid command format. Example: -item");
                    break;
                }
                String itemToRemove = tokens[1];
                itemObservable.unsubscribe(itemToRemove, new ItemObserver(itemToRemove));
                System.out.println("Unsubscribed from " + itemToRemove);
                break;
            case "list":
                itemObservable.listSubscriptions();
                break;
            case "exit":
                System.out.println("Exiting application.");
                System.exit(0);
                break;
            default:
                // Assume any other input is a color
                itemObservable.notifyObservers(tokens[0]);
                break;
        }
    }
}