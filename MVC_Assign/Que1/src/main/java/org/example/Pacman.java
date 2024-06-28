package org.example;

import org.springframework.stereotype.Component;

@Component("pacmanGame")
public class Pacman implements Game {
    @Override
    public void up() {
        System.out.println("Pacman moves up");
    }

    @Override
    public void down() {
        System.out.println("Pacman moves down");
    }

    @Override
    public void left() {
        System.out.println("Pacman moves left");
    }

    @Override
    public void right() {
        System.out.println("Pacman moves right");
    }
}

