package model;

import java.util.Locale;

public class ResourceBundleFile {

    private final String filename;
    private final Locale locale;

    public ResourceBundleFile(String filename, Locale locale) {
        this.filename = filename;
        this.locale = locale;
    }

    public String getFilename() {
        return filename;
    }

    public Locale getLocale() {
        return locale;
    }
}