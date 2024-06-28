package org.example;

class ItemObserver implements Observer {
    private String name;
    private String specialSentence;

    public ItemObserver(String name) {
        this.name = name;
        if (name.equalsIgnoreCase("Frog")) {
            this.specialSentence = "I’m Frog! I am blue today.";
        } else {
            this.specialSentence = "I’m " + name + "! I’m sometimes ";
        }
    }

    @Override
    public void update(String color) {
        if (name.equalsIgnoreCase("Frog")) {
            System.out.println("I’m Frog! I am " + color + " today.");
        } else {
            System.out.println(specialSentence + color);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
