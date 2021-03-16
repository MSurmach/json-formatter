package com.nocompany.parser.types.impl;

import com.nocompany.parser.types.Type;
import java.text.NumberFormat;
import java.text.ParseException;

public class NumberType implements Type {

    private Number value;

    @Override
    public void setValue(String content) {
        try {
            value = NumberFormat.getInstance().parse(content);
        } catch (ParseException ex) {
            System.out.println("Unable to convert string to number format in NumberType class");
        }
    }
    
    @Override
    public String toString() {
        return value.toString();
    }

}
