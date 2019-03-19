package com.jlaamann.smartsql.docker;

import com.jlaamann.smartsql.util.CommandLineUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class DockerServiceImpl implements DockerService {

    @Override
    public String getContainer() {
        String containerName = getContainerName();
        try { // todo vacant port
            List<String> command = Arrays.asList("/bin/bash", "./docker_startup.sh", getContainerName(), "5433");
            CommandLineUtil.runCommand(command, getScriptPath());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        return containerName;
    }

    private String getContainerName() {
        return "test";
//        return UUID.randomUUID().toString();
    }

    @Override
    public void removeContainer(String containerName) {
        try {
            List<String> command = Arrays.asList("/bin/bash", "./docker_remove.sh", getContainerName());
            CommandLineUtil.runCommand(command, getScriptPath());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Path getScriptPath() {
        return Paths.get(System.getProperty("user.dir")).resolve("etc");
    }
}
