package com.jlaamann.smartsql.docker;

public interface DockerService {
    String getContainer();

    void removeContainer(String containerName);
}
