package com.nocompany.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class ObjArrEntity extends Entity {

    private List<Entity> values;
    private boolean isArray;

    public ObjArrEntity(boolean isArray) {
        values = new ArrayList<>();
        this.isArray = isArray;
    }

    @Override
    public void addContent(Object content) {
        values.add((Entity) content);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String name = nameToString();
        if (name != null) {
            builder.append(name);
        }
        builder.append("{");
        for (int count = 0; count < values.size(); count++) {
            builder.append(values.get(count));
            if (count!=values.size()-1) {
                builder.append(",");
            }
        }
        builder.append("}");
        return builder.toString();
    }

}
