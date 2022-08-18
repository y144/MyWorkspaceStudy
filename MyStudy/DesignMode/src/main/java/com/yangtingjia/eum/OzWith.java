package com.yangtingjia.eum;

import java.sql.PreparedStatement;

/**
 * 杨廷甲
 * 2022-08-06
 */
public enum  OzWith {

    WEST("Miss Gulch,aka the defined"),
    NORTH("Glinda"),
    EAST("Wicked"),
    SOUTH("Good Bey");

    private String description;


    private OzWith(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static void main(String[] args) {
        for (OzWith value : OzWith.values()) {
            System.out.println(value + ": " + value.getDescription());
        }
    }
}
