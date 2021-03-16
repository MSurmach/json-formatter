package com.nocompany.parser.entity;

public abstract class Entity {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public abstract void addContent(Object content);

    public String nameToString() {
        StringBuilder builder = new StringBuilder();
        if (name != null) {
            builder.append("\"").append(name).append("\":");
            return builder.toString();
        }
        return null;
    }

}
