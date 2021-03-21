package com.nocompany.parser.handler.impl;

import static com.nocompany.parser.Symbol.*;
import com.nocompany.parser.data.ContentPointer;
import static com.nocompany.parser.data.DB.*;
import com.nocompany.parser.entity.E_Array;
import com.nocompany.parser.entity.E_Object;
import com.nocompany.parser.entity.Entity;
import com.nocompany.parser.handler.I_Handler;

public class LeftBracketHandler extends Handler implements I_Handler {

    private Entity entity;

    @Override
    public void execute() {
        if (!collectSymbol()) {
            entity = initializeEntity();
            if (BUFFER.length() != 0) {
                entity.setName(BUFFER.toString());
                BUFFER.setLength(0);
            }
            STORAGE.push(entity);
        }
    }

    private Entity initializeEntity() {
        char currentSymbol = ContentPointer.getCurrentSymbol();
        return (currentSymbol == LEFT_SQUARE_BRACKET ? new E_Array() : new E_Object());
    }

}
