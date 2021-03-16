package com.nocompany.formatter;

import com.nocompany.formatter.impl.CompactFormatter;
import com.nocompany.formatter.impl.SpaceTabFormatter;
import java.util.HashMap;

public class FormatterSelector {

    private static FormatterSelector selector;
    private HashMap<String, Formatter> mapOfFormatters;

    private FormatterSelector() {
        mapOfFormatters = new HashMap<>();
        mapOfFormatters.put("compact", new CompactFormatter());
        mapOfFormatters.put("space-tab", new SpaceTabFormatter());
    }

    public static FormatterSelector getFormatter() {
        return (selector == null ? new FormatterSelector() : selector);
    }

    public  Formatter getFormatter(String template) {
        return mapOfFormatters.get(template);
    }
}
