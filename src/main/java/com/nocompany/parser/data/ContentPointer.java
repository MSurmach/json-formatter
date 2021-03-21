package com.nocompany.parser.data;

import java.util.List;
import java.util.stream.Collectors;

public class ContentPointer {

    private static List<Character> listOfChars;
    private static short counter;

    public static void initialize(String content) {
        listOfChars = splitToListOfChar(content);
        counter = 0;
    }

    public static short getCounter() {
        return counter;
    }

    public static void toNextSymbol() {
        counter++;
    }

    public static char getSymbolAtPosition(short cursor) {
        return listOfChars.get(cursor);
    }

    private static List<Character> splitToListOfChar(String str) {
        return str.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
    }

    public static char getPreviousSymbol() {
        return (counter > 0 ? listOfChars.get(counter - 1) : listOfChars.get(counter));
    }

    public static boolean isFinished() {
        return counter >= listOfChars.size();
    }

    public static char getCurrentSymbol() {
        return listOfChars.get(counter);
    }
}
