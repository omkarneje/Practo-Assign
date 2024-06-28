package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Gaming {
    private static final Logger logger = LoggerFactory.getLogger(Gaming.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a game to run:");
        System.out.println("1. Pacman");
        System.out.println("2. Mario");
        System.out.println("3. Temple Run");
        System.out.println("0. Default (none)");

        int choice = scanner.nextInt();
        scanner.close();

        Game game;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml")) {
            switch (choice) {
                case 1:
                    game = (Game) context.getBean("pacman");
                    break;
                case 2:
                    game = (Game) context.getBean("mario");
                    break;
                case 3:
                    game = (Game) context.getBean("templeRun");
                    break;
                default:
                    System.out.println("No game selected.");
                    return;
            }

            GameRunner gameRunner = new GameRunner(game);
            gameRunner.run();

        } catch (Exception e) {
            logger.error("An error occurred while running the game:", e);
        }
    }
}
