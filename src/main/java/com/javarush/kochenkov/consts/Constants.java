package com.javarush.kochenkov.consts;

public interface Constants {
    String SELECTION = "Choose what you want?";
    String MAIN_MENU_PROMPT = "Encrypt (\"1\"), Decrypt (\"2\"), Brute Force (\"3\"), Quit (\"4\")";
    String CHOICE_INPUT_PROMPT = "Enter the corresponding number: ";
    String OPTION_NOT_AVAILABLE = "This option is not available";

    String CAESAR_PROMT = "***** Caesar's %s *****%n";
    String ENCRYPT = "Encryption";
    String DECRYPT = "Decryption";

    String BF = "***** BruteForce *****";
    String BRUTEFORCE_COMPLETED = "Brute force decryption completed successfully!";
    String DECRYPT_FILE = "Decrypt file...";
    String SHIFT_EQUAL = "Shift equal: %s%n";

    String INPUT_FILE_PATH = "Enter input file path: ";
    String OUTPUT_FILE_PATH = "Enter output file path: ";
    String CAESAR_SHIFT = "Specify the letter shift: ";

    String ENCRYPTION_SUCCESS = "File successfully encrypted!";
    String DECRYPTION_SUCCESS = "File successfully decrypted!";

    String UNABLE_TO_DETERMINE_SHIFT = "Could not find the correct shift!";

    int MAX_CHARS = 2000;

    String ERROR_MESSAGE = "Error: %s%n";


}
