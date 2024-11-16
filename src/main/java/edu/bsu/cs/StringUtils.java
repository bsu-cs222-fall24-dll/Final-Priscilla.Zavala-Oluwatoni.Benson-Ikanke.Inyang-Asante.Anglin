package edu.bsu.cs;

public final class StringUtils {
    //Helper method
    static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);  // Try to parse the string to an integer
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
