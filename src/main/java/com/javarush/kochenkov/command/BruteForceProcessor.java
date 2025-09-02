package com.javarush.kochenkov.command;

import com.javarush.kochenkov.consts.Constants;
import com.javarush.kochenkov.consts.Keywords;

import java.io.*;
import java.util.Scanner;

public class BruteForceProcessor {
    protected final Scanner scanner;
    SymbolMapper symbolMapper;
    protected Encrypt encrypt;


    public BruteForceProcessor(SymbolMapper symbolMapper) {
        this.symbolMapper = symbolMapper;
        this.scanner = new Scanner(System.in);
        this.encrypt = new Encrypt(symbolMapper);
    }

    public void execute() {
        System.out.println(Constants.BF);

        System.out.print(Constants.INPUT_FILE_PATH);
        String inputFile = scanner.nextLine();

        System.out.print(Constants.OUTPUT_FILE_PATH);
        String outputFile = scanner.nextLine();

        try {
            int shift = findShift(inputFile);
            if (shift == -1) {
                System.out.println(Constants.UNABLE_TO_DETERMINE_SHIFT);
                return;
            }
            System.out.printf(Constants.CAESAR_PROMT, shift);
            System.out.println(Constants.DECRYPT_FILE);

            encrypt.encryptFile(inputFile, outputFile, -shift);
            System.out.printf(Constants.SHIFT_EQUAL, -shift);
            System.out.println(Constants.BRUTEFORCE_COMPLETED);
        } catch (IOException e) {
            System.err.printf(Constants.ERROR_MESSAGE, e.getMessage());
        }
    }

    public int findShift(String filePath) {
        String sample = readStartOfFile(filePath, Constants.MAX_CHARS);
        if (sample.isEmpty()) {
            return -1;
        }
        for (int shift = 0; shift < symbolMapper.charToIndex.size(); shift++) {
            String decrypted = decryptText(sample, shift);
            if (containsKeywords(decrypted)) {
                return shift;
            }
        }
        return -1;
    }

    private String decryptText(String text, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : text.toCharArray()) {
            stringBuilder.append(decryptChar(c, shift));
        }
        return stringBuilder.toString();
    }

    private char decryptChar(char ch, int shift) {
        Integer originalIndex = symbolMapper.charToIndex.get(ch);
        if (originalIndex != null) {
            int totalSymbol = symbolMapper.charToIndex.size();
            int newIndex = (originalIndex - shift) % totalSymbol;
            if (newIndex < 0) {
                newIndex += totalSymbol;
            }
            return symbolMapper.indexToChar.get(newIndex);
        }
        return ch;
    }

    private String readStartOfFile(String filePath, int maxChars) {
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            char[] buffer = new char[1024];
            int totalChars = 0;
            while ((reader.read(buffer)) != -1 && totalChars < maxChars){
                stringBuilder.append(buffer, 0, Math.min(reader.read(buffer), maxChars - totalChars));
                totalChars += reader.read(buffer);
                if(totalChars >= maxChars){
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    private boolean containsKeywords(String text) {
        text = " " + text.toLowerCase() + " ";

        for (String word : Keywords.RUSSIAN_KEYWORDS) {
            if (text.contains(" " + word.toLowerCase() + " ")) {
                return true;
            }
        }
        for (String word : Keywords.ENGLISH_KEYWORDS) {
            if (text.contains(" " + word.toLowerCase() + " "))
                return true;
        }
        return false;

    }
}




