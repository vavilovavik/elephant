package com.webapp.elephant.util;


@pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper
public class HandlebarsHelper {
    public String isSelected(Object firstString, Object secondString) {
        System.out.println(firstString.toString());
        System.out.println(secondString.toString());
        if (firstString.toString().equals(secondString.toString())) {
            return "selected";
        } else {
            return "";
        }
    }
}
