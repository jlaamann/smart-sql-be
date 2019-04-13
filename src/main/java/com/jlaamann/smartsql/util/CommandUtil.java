package com.jlaamann.smartsql.util;

public class CommandUtil {

    public static String getDockerStartupCmd() {
        if (SystemUtil.getOperatingSystem() == SystemUtil.OperatingSystem.LINUX) {
            return "sudo ./docker_startup.sh";
        }
        return "./docker_startup.sh";
    }

    public static String getDockerRemoveCmd() {
        if (SystemUtil.getOperatingSystem() == SystemUtil.OperatingSystem.LINUX) {
            return "sudo ./docker_remove.sh";
        }
        return "./docker_remove.sh";
    }

    public static String getDockerEvalSelectCmd() {
        if (SystemUtil.getOperatingSystem() == SystemUtil.OperatingSystem.LINUX) {
            return "sudo ./docker_eval_select.sh";
        }
        return "./docker_eval_select.sh";
    }

    public static String getDockerExecCmd() {
        if (SystemUtil.getOperatingSystem() == SystemUtil.OperatingSystem.LINUX) {
            return "sudo ./docker_exec.sh";
        }
        return "./docker_exec.sh";
    }

}
