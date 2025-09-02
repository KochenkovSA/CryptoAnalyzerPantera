package com.javarush.kochenkov.command;

import com.javarush.kochenkov.consts.Constants;

import java.io.IOException;
import java.util.Scanner;

public class CipherProcessor {
    protected final Scanner scanner;
    protected final Encrypt cipher;

    public CipherProcessor(SymbolMapper symbolMapper) {
        this.scanner = new Scanner(System.in);
        this.cipher = new Encrypt(symbolMapper);
    }

    public void process(boolean isEncryption) throws IOException {
        String operationName = isEncryption ? Constants.ENCRYPT : Constants.DECRYPT;
        System.out.printf(Constants.CAESAR_PROMT, operationName);

        System.out.print(Constants.INPUT_FILE_PATH);
        String inputFile = scanner.nextLine();

        System.out.print(Constants.OUTPUT_FILE_PATH);
        String outputFile = scanner.nextLine();

        System.out.print(Constants.CAESAR_SHIFT);
        int shift = scanner.nextInt();

        if (!isEncryption) {
            shift = -shift;
        }

        cipher.encryptFile(inputFile, outputFile, shift);
    }
}


