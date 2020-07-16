package services.IO;

import services.resourceBundle.CustomizedResourceBundle;

import java.util.Scanner;

public class Reader {

    private final CustomizedResourceBundle resourceBundle;
    private final Scanner scanner;

    public Reader(CustomizedResourceBundle resourceBundle, Scanner scanner) {
        this.resourceBundle = resourceBundle;
        this.scanner = scanner;
    }

    /**
     * @param key    key mapped to message in properties file that explain what the user MUST be enter as input
     * @param params params to get a customized message
     * @return see {@link Scanner#nextInt()} return
     */
    public int prompt(String key, Object... params) {
        System.out.println(resourceBundle.get(key, params));
        return scanner.nextInt();
    }
}