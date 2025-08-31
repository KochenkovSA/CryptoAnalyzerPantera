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
            Scanner encryptScanner = new Scanner(System.in);
            SymbolMapper symbolMapper = new SymbolMapper();
            Encrypt cipher = new Encrypt(symbolMapper);
            System.out.println("***** Caesar's Encryption *****");
            System.out.print(Constants.INPUT_FILE_PATH);
            String inputFile = encryptScanner.nextLine();

            System.out.print(Constants.OUTPUT_FILE_PATH);
            String outputFile = encryptScanner.nextLine();

            System.out.print(Constants.CAESAR_SHIFT);
            int shift = encryptScanner.nextInt();

            cipher.encryptFile(inputFile, outputFile, shift);
            System.out.printf("Your file is encrypted! Shift : %d%n", shift);
            quit();

        } catch (FileNotFoundException e) {
            System.err.printf("File not found: %s%n", e.getMessage());
        } catch (IOException e) {
            System.err.printf("IO error during encryption: %s%n", e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid shift value!");
        }
    }

    private void decrypt() {
        try {
            Scanner decryptScanner = new Scanner(System.in);
            SymbolMapper symbolMapper = new SymbolMapper();
            Encrypt cipher = new Encrypt(symbolMapper);
            System.out.println("***** Caesar's Decryption *****");
            System.out.print(Constants.INPUT_FILE_PATH);
            String inputFile = decryptScanner.nextLine();

            System.out.print(Constants.OUTPUT_FILE_PATH);
            String outputFile = decryptScanner.nextLine();

            System.out.print(Constants.CAESAR_SHIFT);
            int shift = decryptScanner.nextInt() * -1;

            cipher.encryptFile(inputFile, outputFile, shift);
            System.out.printf("Your file is decrypted! Shift : %d%n", shift);
            quit();

        } catch (FileNotFoundException e) {
            System.err.printf("File not found: %s%n", e.getMessage());
        } catch (IOException e) {
            System.err.printf("IO error during decryption: %s%n", e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid shift value!");
        }
    }

    private void quit() {
        System.exit(0);
    }
}
