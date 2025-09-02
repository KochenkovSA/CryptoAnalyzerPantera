package com.javarush.kochenkov.menu;

import com.javarush.kochenkov.command.BruteForceProcessor;
import com.javarush.kochenkov.command.CipherProcessor;
import com.javarush.kochenkov.command.SymbolMapper;
import com.javarush.kochenkov.consts.Constants;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);

    public MainMenu() {
        askQuestion();
    }

    private void askQuestion() {
        while (true) {
            System.out.println(Constants.SELECTION);
            System.out.println(Constants.MAIN_MENU_PROMPT);
            System.out.print(Constants.CHOICE_INPUT_PROMPT);
            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    encrypt();
                    break;
                case 2:
                    decrypt();
                    break;
                case 3:
                    bruteForce();
                    break;
                case 4:
                    quit();
                    break;
                default:
                    System.out.println(Constants.OPTION_NOT_AVAILABLE);
            }
        }
    }

    private void encrypt() {
        CipherProcessor processor = new CipherProcessor(new SymbolMapper());
        try {
            processor.process(true);
            System.out.println(Constants.ENCRYPTION_SUCCESS);
        } catch (IOException e) {
            System.err.printf(Constants.ERROR_MESSAGE, e.getMessage());
        } finally {
            quit();
        }
    }


    private void decrypt() {
        CipherProcessor processor = new CipherProcessor(new SymbolMapper());
        try {
            processor.process(false);
            System.out.println(Constants.DECRYPTION_SUCCESS);
        } catch (IOException e) {
            System.err.printf(Constants.ERROR_MESSAGE, e.getMessage());
        } finally {
            quit();
        }
    }
    private void bruteForce(){
        BruteForceProcessor processor = new BruteForceProcessor(new SymbolMapper());
        processor.execute();
        quit();
    }

    private void quit() {
        System.exit(0);
    }
}
