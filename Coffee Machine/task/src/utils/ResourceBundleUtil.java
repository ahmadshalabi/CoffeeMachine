package utils;

import models.ResourceBundleFile;
import services.resourceBundle.CustomizedResourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleUtil {

    private static final ResourceBundle CONFIG_RESOURCE_BUNDLE = ResourceBundle.getBundle("config");
    private static final String APP_PROPERTIES_FILENAME = CONFIG_RESOURCE_BUNDLE.getString("properties.filename");

    public static CustomizedResourceBundle getResourceBundle() {
        ResourceBundleFile resourceBundleFile = getResourceBundleFile();
        return new CustomizedResourceBundle(resourceBundleFile);
    }

    private static ResourceBundleFile getResourceBundleFile() {
        return new ResourceBundleFile(APP_PROPERTIES_FILENAME, Locale.getDefault());
    }
}