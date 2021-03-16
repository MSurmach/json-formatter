package com.nocompany.parser.types.impl;

import com.nocompany.parser.types.Type;

public class BooleanType implements Type {

    private Boolean value;

    @Override
    public void setValue(String content) {
        value = Boolean.parseBoolean(content);
    }
    
     @Override
    public String toString() {
        return value.toString();
    }

}
