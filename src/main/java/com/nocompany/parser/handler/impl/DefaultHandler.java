package com.nocompany.parser.handler.impl;

import com.nocompany.parser.handler.I_Handler;

public class DefaultHandler extends Handler implements I_Handler {

    @Override
    public void execute() {
        collectSymbol();
    }
}
