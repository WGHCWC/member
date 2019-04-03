package com.utils;

import java.lang.reflect.Field;
import java.util.HashMap;

public class FieldsName {

    private static final HashMap<Class, String[]> FiledNames = new HashMap<>();


    public static String[] getName(Class clazz) {


        if (FiledNames.get(clazz) != null) {
            return FiledNames.get(clazz);
        }

        Field[] fields = clazz.getDeclaredFields();
        String[] memberField = new String[fields.length];
        for (int i = 0; i < memberField.length; i++) {
            memberField[i] = fields[i].getName();

        }
        FiledNames.put(clazz, memberField);

        return memberField;


    }


}
