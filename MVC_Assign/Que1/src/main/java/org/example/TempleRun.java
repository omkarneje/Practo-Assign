package org.example;

import org.springframework.stereotype.Component;

@Component("templeRunGame")
public class TempleRun implements Game {
    @Override
    public void up() {
        System.out.println("Temple Runner jumps up");
    }

    @Override
    public void down() {
        System.out.println("Temple Runner ducks down");
    }

    @Override
    public void left() {
        System.out.println("Temple Runner moves left");
    }

    @Override
    public void right() {
        System.out.println("Temple Runner moves right");
    }
}

