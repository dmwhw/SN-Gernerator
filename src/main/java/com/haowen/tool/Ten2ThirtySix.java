package com.haowen.tool;

import java.util.HashMap;

public class Ten2ThirtySix {

    public static String tenTo36(long num) {
        StringBuffer sBuffer = new StringBuffer();

        if(num == 0) {
            sBuffer.append("0");
        }
        while(num > 0) {
            sBuffer.append(Varriable.X36_CHAR_ARRAY[ new Long(num % 36l).intValue()]);
            num = num / 36;
        }

        return sBuffer.reverse().toString();
    }

    public static int thirtysixToTen(String string) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < Varriable.X36.length(); i++) {
            map.put(Varriable.X36.charAt(i), i);
        }

        int size = string.length();
        int num = 0;
        for(int i = 0; i<size; i++) {
            String char2str = String.valueOf(string.charAt(i)).toUpperCase();
            num = (int) (map.get(char2str.charAt(0)) * Math.pow(36, size - i - 1) + num);
        }

        return num;
    }

}
