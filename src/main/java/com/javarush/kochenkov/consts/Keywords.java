package com.javarush.kochenkov.consts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Keywords {
    String RU_KEY_WORDS = "и, в, не, на, я, ты, он, она, вы, что, где, когда, с, по, как, а, то, все, у, за";
    String ENG_KEY_WORDS = "and, in, not, on, I, you, he, she, you, what, where, when, with, by, how, a, that, all, at, for";

    List<String> RUSSIAN_KEYWORDS = new ArrayList<>(Arrays.asList(RU_KEY_WORDS.split(", ")));
    List<String> ENGLISH_KEYWORDS = new ArrayList<>(Arrays.asList(ENG_KEY_WORDS.split(", ")));

    String ALL_SYMBOLS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "0123456789" +
            "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n\r\t ";


}
