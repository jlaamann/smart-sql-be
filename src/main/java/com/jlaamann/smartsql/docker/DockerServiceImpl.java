package com.jlaamann.smartsql.docker;

import com.jlaamann.smartsql.util.StreamGobbler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class DockerServiceImpl implements DockerService {

    @Override
    public String getContainer() {
        try {
            String homeDir = System.getProperty("user.home");
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("sh", "-c", "echo $USER");
            builder.directory(new File(System.getProperty("user.home")));
            Process process = builder.start();
            StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
            Executors.newSingleThreadExecutor().submit(streamGobbler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getContainerName() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void removeContainer(String containerId) {

    }
}
