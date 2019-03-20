package com.jlaamann.smartsql.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {

    // NB! Keep in sync with etc folder structure

    public static Path getScriptPath() {
        return Paths.get(System.getProperty("user.dir")).resolve("etc");
    }

    public static Path getEvalScriptPath() {
        return Paths.get(System.getProperty("user.dir")).resolve("etc/eval");
    }
}
