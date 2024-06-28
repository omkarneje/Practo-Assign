package Behavorial;

import java.util.Observer;

// Observable interface
interface Observable {
    void subscribe(String itemName, java.util.Observer observer);
    void unsubscribe(String itemName, Observer observer);
    void notifyObservers(String color);
    void listSubscriptions();
}