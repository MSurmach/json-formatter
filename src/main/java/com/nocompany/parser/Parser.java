package com.nocompany.parser;

import com.nocompany.parser.handler.HandlerSelector;
import com.nocompany.parser.entity.Entity;
import java.util.Stack;
import com.nocompany.parser.handler.I_Handler;

public class Parser {

    public final static Stack<Entity> STORAGE = new Stack<>();
    public final static StringBuilder BUFFER = new StringBuilder();
    public static Pointer PARSEBLE;

    public Parser(String json) {
        PARSEBLE = new Pointer(json);
    }  
    
    public static boolean isBufferEmpty() {
        return BUFFER.length()==0;
    }
    
    public static void clearBuffer(){
        BUFFER.setLength(0);
    }

    public void parse() {
        while (!PARSEBLE.isFinished()) {
            char symbol = PARSEBLE.getSymbol();
            I_Handler handler = HandlerSelector.getSelector().processSymbol(symbol);
            handler.execute();
            PARSEBLE.toNextSymbol();
        }
    }
}
