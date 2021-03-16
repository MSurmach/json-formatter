package com.nocompany.parser.types.impl;

import com.nocompany.parser.types.Type;

public class NullType implements Type {

    private String value;

    @Override
    public void setValue(String content) {
        value = null;
    }

     @Override
    public String toString() {
        return value;
    }
}
