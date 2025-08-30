package com.javarush.kochenkov;

import java.io.*;

public class Encrypt {
    private final SymbolMapper symbolMapper;
    private static final int BUFFER_SIZE = 8192;

    public Encrypt(SymbolMapper symbolMapper) {
        this.symbolMapper = symbolMapper;
    }

    private char encryptChar(char character, int shift) {
        Integer originalIndex = symbolMapper.charToIndex.get(character);

        if (originalIndex != null) {
            int totalSymbols = symbolMapper.charToIndex.size();
            int newIndex = (originalIndex + shift) % totalSymbols;
            if (newIndex < 0) {
                newIndex += totalSymbols;
            }
            return symbolMapper.indexToChar.get(newIndex);
        }
        return character;
    }

    public void encryptFile(String inputFile, String outputFile, int shift) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)), BUFFER_SIZE);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)), BUFFER_SIZE)) {

            char[] buffer = new char[BUFFER_SIZE];
            int charsRead;

            while ((charsRead = reader.read(buffer)) != -1) {
                for (int i = 0; i < charsRead; i++) {
                    buffer[i] = encryptChar(buffer[i], shift);
                }
                writer.write(buffer, 0, charsRead);
            }
        }
    }
}
