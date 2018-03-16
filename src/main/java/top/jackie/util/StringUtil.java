package top.jackie.util;

public class StringUtil {

    public static String firstLetterUpper(String string) {
        if (string == null) {
            return "";
        }
        char[] c = string.toCharArray();
        if (c[0] >= 'a' && c[0] <= 'z') {
            c[0] = (char) (c[0] - 32);
        }
        return new String(c);
    }

}
