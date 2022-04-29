package net.osek.survcad.utils;

public class StringUtil {

    public static String fixUrlForCss(String url) {
        url = url.replace('\\', '/');
        url = url.replaceAll(" ", "%20");

        url = "file:///" + url;

        return url;
    }
}
