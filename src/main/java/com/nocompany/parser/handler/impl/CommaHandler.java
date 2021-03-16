package com.nocompany.parser.handler.impl;

import static com.nocompany.parser.Parser.BUFFER;
import static com.nocompany.parser.Parser.STORAGE;
import static com.nocompany.parser.Parser.clearBuffer;
import static com.nocompany.parser.Parser.isBufferEmpty;
import com.nocompany.parser.entity.Entity;
import com.nocompany.parser.handler.I_Handler;

public class CommaHandler extends Handler implements I_Handler {

    @Override
    public void execute() {
        if (!collectSymbol()) {
            if (!isBufferEmpty()) {
                STORAGE.peek().addContent(BUFFER.toString());
                clearBuffer();
            }
            Entity topEntity = STORAGE.pop();
            STORAGE.peek().addContent(topEntity);
        }
    }
}
