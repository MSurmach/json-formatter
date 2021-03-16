package com.nocompany.parser.entity;

import org.junit.Test;
import static org.junit.Assert.*;

public class EntityTest {

    @Test
    public void testNameToString() {
        Entity testEntity = new ObjArrEntity(true);
        String name = "hello";
        testEntity.setName(name);
        String expectedName = new StringBuilder().append("\"").append(name).append("\":").toString();
        assertEquals(expectedName, testEntity.nameToString());
    }

}
