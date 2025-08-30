package com.javarush.kochenkov;

import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);

    MainMenu() {
        askQuestion();
    }

    private void askQuestion() {
        while (true) {
            System.out.println("Choose what you want?");
            System.out.println("Encrypt (\"1\"), Decrypt (\"2\"), Quit (\"3\")");
            System.out.println("Enter the corresponding number:");
            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    encrypt();
                    break;
                case 2:
                    decrypt();
                    break;
                case 3:
                    quit();
                    break;
                default:
                    System.out.println("This option is not available");
            }
        }
    }

    private void encrypt() {

    }

    private void decrypt() {

    }

    private void quit() {
        System.exit(0);
    }
}
