package com.nocompany.parser.handler.impl;

import static com.nocompany.parser.Parser.PARSEBLE;
import static com.nocompany.parser.Symbol.*;
import com.nocompany.parser.handler.I_Handler;

public class DoubleQuatationHandler extends Handler implements I_Handler {

    private boolean isEscaped() {
        return PARSEBLE.getPreviousSymbol() == REVERSE_SOLIDUS;
    }

    @Override
    public void execute() {
        if (isEscaped()) {
            collectSymbol();
        } else {
            isInsideString = !isInsideString;
        }
    }
}
