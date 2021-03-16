package com.nocompany.parser.handler.impl;

import static com.nocompany.parser.Parser.*;
import static com.nocompany.parser.Symbol.*;
import com.nocompany.parser.entity.Entity;
import com.nocompany.parser.entity.ObjArrEntity;
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
        char currentSymbol = PARSEBLE.getCurrentSymbol();
        return (currentSymbol == LEFT_SQUARE_BRACKET ? new ObjArrEntity(true) : new ObjArrEntity(false));
    }

}
