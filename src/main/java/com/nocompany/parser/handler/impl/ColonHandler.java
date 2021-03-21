package com.nocompany.parser.handler.impl;

import static com.nocompany.parser.data.DB.*;
import static com.nocompany.parser.Symbol.*;
import com.nocompany.parser.data.ContentPointer;
import com.nocompany.parser.entity.*;
import com.nocompany.parser.handler.I_Handler;

public class ColonHandler extends Handler implements I_Handler {

    @Override
    public void execute() {
        if (!collectSymbol() && !isBraceAfterColon()) {
            Entity newField = new E_KeyValue();
            newField.setName(BUFFER.toString());
            BUFFER.setLength(0);
            STORAGE.push(newField);
        }
    }

    private boolean isBraceAfterColon() {
        short pos = (short) (ContentPointer.getCounter() + 1);
        char temp = ContentPointer.getSymbolAtPosition(pos);
        while (temp == SPACE || FORMATTING_SYMBOLS.contains(temp)) {
            pos++;
            temp = ContentPointer.getSymbolAtPosition(pos);
        }
        return temp == LEFT_CURLY_BRACKET || temp == LEFT_SQUARE_BRACKET;
    }

}
