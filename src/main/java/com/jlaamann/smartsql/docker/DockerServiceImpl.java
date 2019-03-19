package com.jlaamann.smartsql.docker;

import com.jlaamann.smartsql.util.CommandLineUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class DockerServiceImpl implements DockerService {

    @Override
    public String getContainer() {
        String containerName = getContainerName();
        try { // todo vacant port
            List<String> command = Arrays.asList("/bin/bash", "./docker_startup.sh", containerName, getVacantPort());
            CommandLineUtil.runCommand(command, getScriptPath());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        return containerName;
    }

    private String getContainerName() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private String getVacantPort() throws IOException{
        ServerSocket socket = new ServerSocket(0);
        socket.setReuseAddress(true);
        return String.valueOf(socket.getLocalPort());
    }

    @Override
    public void removeContainer(String containerName) {
        try {
            List<String> command = Arrays.asList("/bin/bash", "./docker_remove.sh", containerName);
            CommandLineUtil.runCommand(command, getScriptPath());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Path getScriptPath() {
        return Paths.get(System.getProperty("user.dir")).resolve("etc");
    }
}
