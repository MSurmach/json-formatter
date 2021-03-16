package com.nocompany.formatter;

import com.nocompany.parser.entity.Entity;
import java.util.Stack;

public interface Formatter {
    String format(Stack<Entity> json);
}
