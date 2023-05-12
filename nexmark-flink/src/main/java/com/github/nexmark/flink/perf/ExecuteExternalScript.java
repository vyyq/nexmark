package com.github.nexmark.flink.perf;

import java.io.IOException;

public class ExecuteExternalScript {
    private Process scriptProcess;
    private String script;
    private long scriptPid;

    public ExecuteExternalScript() {
        System.out.println("Initializing script executor");
    }

    public ExecuteExternalScript(String script) {
        this.script = script;
        System.out.println("Initializing script executor with script: " + this.script);
    }

    public int getJvmPid() {
        String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        return Integer.parseInt(processName.split("@")[0]);
    }

    public void startScript() throws IOException {
        System.out.println("Starting script " + this.script);
        ProcessBuilder processBuilder = new ProcessBuilder("/usr/bin/bash", "-c", this.script);
        scriptProcess = processBuilder.start();
        this.scriptPid = scriptProcess.pid();
    }

    public void startScript(String script) throws IOException {
        System.out.println("Start executing script " + script);
        ProcessBuilder processBuilder = new ProcessBuilder("/usr/bin/bash", "-c", script);
        scriptProcess = processBuilder.start();
        this.scriptPid = scriptProcess.pid();
    }

    public void stopScript(boolean sendSIGINT) {
        System.out.println("Stopping script process " + scriptPid);
        if (scriptProcess != null) {
            if (sendSIGINT) {
                ProcessBuilder killProcessBuilder = new ProcessBuilder("kill -INT " + scriptPid);
                try {
                    Process killProcess = killProcessBuilder.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                scriptProcess.destroy();
            }
        }
    }
}
