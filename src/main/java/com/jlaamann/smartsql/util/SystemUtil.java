package com.jlaamann.smartsql.util;

public class SystemUtil {

    // TODO: remove entirely since sudo is not necessary on linux

    public enum OperatingSystem {
        LINUX,
        MAC
    }

    public static OperatingSystem getOperatingSystem() {
//        String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
//        if (os.contains("linux")) {
//            return OperatingSystem.LINUX;
//        }
        return OperatingSystem.MAC;
    }
}
