package com.jlaamann.smartsql.util;

public class CommandUtil {

    public static String getDockerStartupCmd() {
        return "./docker_startup.sh";
    }

    public static String getDockerRemoveCmd() {
        return "./docker_remove.sh";
    }

    public static String getDockerEvalSelectCmd() {
        return "./docker_eval_select.sh";
    }

    public static String getDockerExecCmd() {
        return "./docker_exec.sh";
    }

}
