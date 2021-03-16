package com.nocompany.formatter.impl;

import com.nocompany.formatter.Formatter;
import com.nocompany.parser.entity.Entity;
import java.util.Stack;

public class CompactFormatter implements Formatter {

    @Override
    public String format(Stack<Entity> json) {
        StringBuilder builder = new StringBuilder();
        for (Entity entity : json) {
            builder.append(entity.toString());
        }
        return builder.toString();
    }

}
