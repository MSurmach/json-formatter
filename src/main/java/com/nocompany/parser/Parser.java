package com.nocompany.parser;

import com.nocompany.parser.data.ContentPointer;
import com.nocompany.parser.handler.HandlerSelector;
import com.nocompany.parser.handler.I_Handler;

public class Parser {

    public Parser(String json) {
        ContentPointer.initialize(json);
    }

    public void parse() {
        while (!ContentPointer.isFinished()) {
            char symbol = ContentPointer.getCurrentSymbol();
            I_Handler handler = HandlerSelector.getSelector().processSymbol(symbol);
            handler.execute();
            ContentPointer.toNextSymbol();
        }
    }
}
