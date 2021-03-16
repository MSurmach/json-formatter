package com.nocompany.parser.handler.impl;

import static com.nocompany.parser.Parser.*;
import static com.nocompany.parser.Symbol.*;
import com.nocompany.parser.entity.*;
import com.nocompany.parser.handler.I_Handler;

public class ColonHandler extends Handler implements I_Handler {

    @Override
    public void execute() {
        if (!collectSymbol() && !isBraceAfterColon()) {
            Entity newField = new FieldEntity();
            newField.setName(BUFFER.toString());
            BUFFER.setLength(0);
            STORAGE.push(newField);
        }
    }

    private boolean isBraceAfterColon() {
        short pos = (short) (PARSEBLE.getCounter() + 1);
        char temp = PARSEBLE.getSymbolAtPosition(pos);
        while (temp == SPACE) {
            pos++;
            temp = PARSEBLE.getSymbolAtPosition(pos);
        }
        temp = PARSEBLE.getSymbolAtPosition(pos);
        return temp == LEFT_CURLY_BRACKET || temp == LEFT_SQUARE_BRACKET;
    }

}
