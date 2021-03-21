package com.nocompany.parser.handler.impl;

import static com.nocompany.parser.data.DB.*;

import com.nocompany.parser.data.ContentPointer;
import com.nocompany.parser.handler.I_Handler;

abstract class Handler implements I_Handler {

    static boolean isInsideString;

    boolean collectSymbol() {
        char current = ContentPointer.getCurrentSymbol();
        if (isInsideString) BUFFER.append(current);
        return isInsideString;
    }

    @Override
    public abstract void execute();
}
