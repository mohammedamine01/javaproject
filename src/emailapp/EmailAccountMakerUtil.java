package emailapp;

import java.util.Locale;

public class EmailAccountMakerUtil {

    public static final String LITTLE_SPACE = " ";
    public static final String DASH = "-";
    public static final String REGEX_FOR_MANY_SPACE = "\\s+";

    public static String toLowerCase(String ss) {
        return ss.toLowerCase(Locale.ROOT);
    }

    public static String replaceSpaceByDash(String ss) {
        return ss.trim().replaceAll(REGEX_FOR_MANY_SPACE, LITTLE_SPACE).replace(LITTLE_SPACE, DASH);
    }


    public static void print(String message) {
        System.out.println(message);
    }

    public static String toString(char[] chars) {
        return new String(chars);
    }
}
