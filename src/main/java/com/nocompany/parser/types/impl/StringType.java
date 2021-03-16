package com.nocompany.parser.types.impl;

import com.nocompany.parser.types.Type;

public class StringType implements Type {

    private String value;

    @Override
    public void setValue(String content) {
        value = content;
    }

    @Override
    public String toString() {
        return "\""+value+"\"";
    }

}
