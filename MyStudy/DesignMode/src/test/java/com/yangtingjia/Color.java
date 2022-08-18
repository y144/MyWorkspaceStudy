package com.yangtingjia;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

/**
 * 杨廷甲
 * 2022-06-28
 */
public enum  Color {
    RED, GREEN, BLANK, YELLOW;

    @Override
    public String toString(){
        return "color:" + super.toString();
    }

    public static void main(String[] args) {
        System.out.println(Color.RED);
        System.out.println(Color.RED.BLANK);
        System.out.println(RED.ordinal());
        System.out.println(RED.compareTo(BLANK));
    }

    @Test
    public void test(){

    }
}
