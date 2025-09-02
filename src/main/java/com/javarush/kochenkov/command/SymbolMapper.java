package com.javarush.kochenkov.command;

import com.javarush.kochenkov.consts.Keywords;

import java.util.HashMap;
import java.util.Map;

public class SymbolMapper {
    private final String allSymbols;
    public final Map<Character, Integer> charToIndex;
    public final Map<Integer, Character> indexToChar;

    public SymbolMapper() {
        this.allSymbols = Keywords.ALL_SYMBOLS;
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
