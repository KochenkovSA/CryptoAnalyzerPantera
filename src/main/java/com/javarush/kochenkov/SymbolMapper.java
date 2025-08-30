package com.javarush.kochenkov;

import java.util.HashMap;
import java.util.Map;

public class SymbolMapper {
    private final String allSymbols;
    private final Map<Character, Integer> charToIndex;
    private final Map<Integer, Character> indexToChar;

    public SymbolMapper(String customSymbols) {
        this.allSymbols = customSymbols;
        this.charToIndex = new HashMap<>();
        this.indexToChar = new HashMap<>();
        associatingSymbols();
    }

    public SymbolMapper() {
        this.allSymbols = Constants.ALL_SYMBOLS;
        this.charToIndex = new HashMap<>();
        this.indexToChar = new HashMap<>();
        associatingSymbols();
    }

    private void associatingSymbols() {
        for (int i = 0; i < allSymbols.length(); i++) {
            char c = allSymbols.charAt(i);
            charToIndex.put(c, i);
            indexToChar.put(i, c);
        }
    }
}
