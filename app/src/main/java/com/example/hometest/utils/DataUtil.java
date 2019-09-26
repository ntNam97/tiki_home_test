package com.example.hometest.utils;

public class DataUtil {

    public static String formatString(String keyword) {

        int min = keyword.length();
        int index = 0;

        if (!keyword.contains(" ")) {
            return keyword;
        }

        for (int i = 0; i < keyword.length(); i++) {
            char c = keyword.charAt(i);
            if (c == ' ') {
                int diff = Math.abs(keyword.substring(0, i).length() - keyword.substring(i + 1).length());
                if (diff < min) {
                    min = diff;
                    index = i;
                }
            }
        }

        String result = keyword.substring(0, index);
        result += "\n";
        result += keyword.substring(index + 1);

        return result;
    }
}
