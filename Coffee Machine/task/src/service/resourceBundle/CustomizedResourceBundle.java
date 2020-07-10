package service.resourceBundle;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class CustomizedResourceBundle extends ResourceBundle {

    private final String filename;
    private final Locale locale;

    public CustomizedResourceBundle(String filename, Locale locale) {
        this.filename = filename;
        this.locale = locale;
    }

    private ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle(filename, locale);
    }

    public String get(String key, Object... args) {
        return MessageFormat.format(getResourceBundle().getString(key), args);
    }

    @Override
    protected Object handleGetObject(String key) {
        ResourceBundle resourceBundle = getResourceBundle();
        return resourceBundle != null ? resourceBundle.getString(key) : null;
    }

    @Override
    public Enumeration<String> getKeys() {
        ResourceBundle resourceBundle = getResourceBundle();
        return resourceBundle != null ? resourceBundle.getKeys() : Collections.emptyEnumeration();
    }
}