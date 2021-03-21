package com.nocompany.parser.handler.impl;

import static com.nocompany.parser.Symbol.*;
import com.nocompany.parser.data.ContentPointer;
import com.nocompany.parser.handler.I_Handler;

public class DoubleQuatationHandler extends Handler implements I_Handler {

    private boolean isEscaped() {
        return ContentPointer.getPreviousSymbol() == REVERSE_SOLIDUS;
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
