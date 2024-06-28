package org.example;


public class GameRunner {
    private final Game game;

    public GameRunner(Game game) {
        this.game = game;
    }

    public void run() {
        game.up();
        game.down();
        game.left();
        game.right();
    }
}



