package com.jlaamann.smartsql.util;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Executors;

public class CommandLineUtil {

    public static void runCommand(List<String> command, Path path) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(command);
        builder.directory(path.toFile());
        Process process = builder.start();
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        process.waitFor();
    }
}
