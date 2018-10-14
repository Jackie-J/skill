package top.jackie.java8.lambda;

public class Letter {

    public static String addHeader(String header) {
        return "From Jackie To Jack " + header;
    }

    public static String AddFooter(String footer) {
        return footer + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

}
