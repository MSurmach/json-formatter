package com.nocompany.parser.handler;

import com.nocompany.parser.handler.impl.*;

import java.util.HashMap;

import static com.nocompany.parser.Symbol.*;

public class HandlerSelector {

    private static HandlerSelector selector;
    private final HashMap<Character, I_Handler> map;

    private HandlerSelector() {
        map = new HashMap();
        map.put(DOUBLE_QUOTATION, new DoubleQuatationHandler());
        map.put(LEFT_SQUARE_BRACKET, new LeftBracketHandler());
        map.put(LEFT_CURLY_BRACKET, new LeftBracketHandler());
        map.put(COMMA, new CommaHandler());
        map.put(RIGHT_CURLY_BRACKET, new RightBracketHandler());
        map.put(RIGHT_SQUARE_BRACKET, new RightBracketHandler());
        map.put(COLON, new ColonHandler());
    }

    public static HandlerSelector getSelector() {
        return (selector == null ? new HandlerSelector() : selector);
    }

    public I_Handler processSymbol(char symbol) {
        return (map.containsKey(symbol) ? map.get(symbol) : new DefaultHandler());
    }
}
