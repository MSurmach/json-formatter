package com.nocompany.parser;

import java.util.List;
import java.util.stream.Collectors;

public class Pointer {

    private final List<Character> listOfChars;
    private short counter;

    public Pointer(String content) {
        listOfChars = splitToListOfChar(content);
        counter = 0;
    }

    public short getCounter() {
        return counter;
    }

    public char getSymbol() {
        return listOfChars.get(counter);
    }

    public List<Character> getListOCharacters() {
        return listOfChars;
    }

    public void toNextSymbol() {
        counter++;
    }

    public char getSymbolAtPosition(short cursor) {
        return listOfChars.get(cursor);
    }

    private List<Character> splitToListOfChar(String str) {
        return str.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
    }

    public char getPreviousSymbol() {
        return (counter > 0 ? listOfChars.get(counter - 1) : listOfChars.get(counter));
    }

    public boolean isFinished() {
        return counter >= listOfChars.size();
    }

    public char getCurrentSymbol() {
        return listOfChars.get(counter);
    }
}
