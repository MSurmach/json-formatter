package com.nocompany.parser.launcher;

import com.nocompany.parser.Parser;

public class Runner {

    public static void main(String[] args) {
        String pathToFile = "/home/maksim/NetBeansProjects/json_formatter/resources/jsonTest5.json";
        String json = new ContentGetter(pathToFile).getJSONAsString();
        Parser parser = new Parser(json);
        parser.parse();
        System.out.println("");
    }
}
