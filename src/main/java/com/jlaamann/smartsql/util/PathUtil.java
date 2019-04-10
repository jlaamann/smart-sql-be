package com.jlaamann.smartsql.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {

    // NB! Keep in sync with etc folder structure

    public static Path getScriptPath() {
        if (SystemUtil.getOperatingSystem() == SystemUtil.OperatingSystem.LINUX) {
            return Paths.get(System.getProperty("user.dir")).resolve("etc/linux");

        }
        return Paths.get(System.getProperty("user.dir")).resolve("etc/mac");
    }

    public static Path getEvalScriptPath() {
        if (SystemUtil.getOperatingSystem() == SystemUtil.OperatingSystem.LINUX) {
            return Paths.get(System.getProperty("user.dir")).resolve("etc/linux/eval");
        }
        return Paths.get(System.getProperty("user.dir")).resolve("etc/mac/eval");
    }
}
