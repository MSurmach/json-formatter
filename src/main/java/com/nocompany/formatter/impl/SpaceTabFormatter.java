package com.nocompany.formatter.impl;

import com.nocompany.formatter.Formatter;
import com.nocompany.parser.entity.Entity;
import java.util.Stack;

public class SpaceTabFormatter implements Formatter {

    @Override
    public String format(Stack<Entity> json) {
        return "spaceTabFormatter";
    }

}
