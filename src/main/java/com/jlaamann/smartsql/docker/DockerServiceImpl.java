package com.jlaamann.smartsql.docker;

import com.jlaamann.smartsql.util.CommandLineUtil;
import com.jlaamann.smartsql.util.CommandUtil;
import com.jlaamann.smartsql.util.PathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class DockerServiceImpl implements DockerService {

    @Override
    public String getContainer() {
        String containerName = getContainerName();
        try {
            List<String> command = Arrays.asList(CommandUtil.getDockerStartupCmd(), containerName, getVacantPort());
            CommandLineUtil.runCommand(command, PathUtil.getScriptPath());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        return containerName;
    }

    private String getContainerName() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private String getVacantPort() throws IOException {
        ServerSocket socket = new ServerSocket(0);
        socket.setReuseAddress(true);
        String port = String.valueOf(socket.getLocalPort());
        socket.close();
        return port;
    }

    @Override
    public void removeContainer(String containerName) {
        try {
            List<String> command = Arrays.asList(CommandUtil.getDockerRemoveCmd(), containerName);
            CommandLineUtil.runCommand(command, PathUtil.getScriptPath());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
