package com.nocompany.parser.entity;

import com.nocompany.parser.types.Type;
import com.nocompany.parser.types.impl.BooleanType;
import com.nocompany.parser.types.impl.NullType;
import com.nocompany.parser.types.impl.StringType;

public class FieldEntity extends Entity {

    private Type type;

    private Type getTypeFromString(String content) {
        switch (content) {
            case ("null"):
                return new NullType();
            case ("true"):
            case ("false"):
                return new BooleanType();
            default:
                return new StringType();
        }
    }

    @Override
    public void addContent(Object content) {
        type = getTypeFromString(content.toString());
        type.setValue(content.toString());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String name = nameToString();
        if (name != null) {
            builder.append(name);
        }
        builder.append(type.toString());
        return builder.toString();
    }

}
