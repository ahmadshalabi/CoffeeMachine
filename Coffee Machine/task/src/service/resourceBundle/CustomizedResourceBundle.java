package service.resourceBundle;

import model.ResourceBundleFile;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class CustomizedResourceBundle extends ResourceBundle {

    private final ResourceBundleFile resourceBundleFile;

    public CustomizedResourceBundle(ResourceBundleFile resourceBundleFile) {
        this.resourceBundleFile = resourceBundleFile;
    }

    private ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle(resourceBundleFile.getFilename(), resourceBundleFile.getLocale());
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