package com.jlaamann.smartsql.util;

import java.util.Locale;

public class SystemUtil {

    public enum OperatingSystem {
        LINUX,
        MAC
    }

    public static OperatingSystem getOperatingSystem() {
        String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (os.contains("linux")) {
            return OperatingSystem.LINUX;
        }
        return OperatingSystem.MAC;
    }
}
