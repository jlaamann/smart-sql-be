package com.jlaamann.smartsql.util;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class CommandLineUtil {

    public static void runCommand(List<String> command, Path path) throws IOException, InterruptedException {
        runCommand(command, path, System.out::println);
    }

    public static void runCommand(List<String> command, Path path, Consumer<String> consumer)
            throws IOException, InterruptedException{
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(command);
        builder.redirectErrorStream(true);
        builder.directory(path.toFile());
        Process process = builder.start();
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), consumer);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        process.waitFor();
    }
}
