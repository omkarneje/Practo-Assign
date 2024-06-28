package org.example;

    class ItemObservable implements Observable {
        private Map<String, Set<Observer>> subscriptions;

        public ItemObservable() {
            this.subscriptions = new HashMap<>();
        }

        @Override
        public void subscribe(String itemName, Observer observer) {
            subscriptions.computeIfAbsent(itemName, k -> new HashSet<>()).add(observer);
        }

        @Override
        public void unsubscribe(String itemName, Observer observer) {
            subscriptions.computeIfPresent(itemName, (key, observers) -> {
                observers.remove(observer);
                if (observers.isEmpty()) {
                    return null;
                }
                return observers;
            });
        }

        @Override
        public void notifyObservers(String color) {
            subscriptions.entrySet().stream()
                    .filter(entry -> entry.getKey().equalsIgnoreCase(color))
                    .flatMap(entry -> entry.getValue().stream())
                    .forEach(observer -> observer.update(color));
        }

        @Override
        public void listSubscriptions() {
            System.out.println("Current subscriptions:");
            subscriptions.forEach((itemName, observers) -> {
                System.out.print(itemName + ": ");
                observers.forEach(observer -> System.out.print(observer + " "));
                System.out.println();
            });
        }
    }

