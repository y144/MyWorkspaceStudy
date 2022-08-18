package com.yangtingjia;

import java.util.Scanner;
import java.util.Stack;

/**
 * 杨廷甲
 * 2022-07-03
 */
public class StrRemove {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z')) {
                System.out.println(0);
                return;
            }
            if(stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            }else {
                stack.pop();
            }
        }
        System.out.println(stack.size());
    }
}
