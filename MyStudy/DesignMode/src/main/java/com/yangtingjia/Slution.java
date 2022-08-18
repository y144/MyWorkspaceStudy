package com.yangtingjia;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] StringArray = s.split(" ");
        String p = scanner.nextLine();
        Solution solution = new Solution();
        String out = "";
        for(int i = 0;i < StringArray.length ;i++ ){
//            System.out.println(StringArray[i]);
            if (solution.isMatch(StringArray[i], p) == true){
                out += String.valueOf(i) + ",";

            }
        }
        if (out.length()==0){
            System.out.println(-1);
        }else {
            System.out.println(out.substring(0,out.length()-1));
        }

    }
    public  boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
