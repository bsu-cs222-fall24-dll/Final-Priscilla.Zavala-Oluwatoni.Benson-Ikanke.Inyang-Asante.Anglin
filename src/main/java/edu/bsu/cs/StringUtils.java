package edu.bsu.cs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {
    //Helper method
    static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String extractFirstNumber(String str) {
        //handle null and/or empty strings
        if (str == null || str.isEmpty()) {
            return null;
        }

        //handle specified patterns
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
