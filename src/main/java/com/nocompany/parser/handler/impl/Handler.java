package com.nocompany.parser.handler.impl;

import com.nocompany.parser.Parser;
import com.nocompany.parser.handler.I_Handler;

abstract class Handler implements I_Handler {

    static boolean isInsideString;

    boolean collectSymbol() {
        if (isInsideString) {
            char current = Parser.PARSEBLE.getCurrentSymbol();
            Parser.BUFFER.append(current);
        }
        return isInsideString;
    }

    @Override
    public abstract void execute();
}
