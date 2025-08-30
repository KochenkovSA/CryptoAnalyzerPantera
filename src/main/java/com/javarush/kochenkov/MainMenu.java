package com.javarush.kochenkov;

import java.io.FileNotFoundException;
import java.io.IOException;
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
            System.out.print("Enter the corresponding number: ");
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
        try {
            Scanner localScanner = new Scanner(System.in); // !!!Пришлось сделать локальный сканер из-за ошибки возникающей при указании путей IO и значения сдвига!!!
            SymbolMapper symbolMapper = new SymbolMapper();
            Encrypt cipher = new Encrypt(symbolMapper);
            System.out.println("***** Caesar's Encryptor *****");
            System.out.print("Enter the path to the file: ");
            String inputFile = localScanner.nextLine();

            System.out.print("Specify the path to the save location: ");
            String outputFile = localScanner.nextLine();

            System.out.print("Specify the letter shift: ");
            int shift = Integer.parseInt(localScanner.nextLine());


            cipher.encryptFile(inputFile, outputFile, shift);
            quit();

        } catch (FileNotFoundException e) {
            System.err.printf("File not found: %s%n", e.getMessage());
        } catch (IOException e) {
            System.err.printf("IO error during encryption: %s%n", e.getMessage());
        }
    }

    private void decrypt() {

    }

    private void quit() {
        System.exit(0);
    }
}
