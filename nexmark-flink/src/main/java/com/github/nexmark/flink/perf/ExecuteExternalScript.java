package com.github.nexmark.flink.perf;

import java.io.IOException;

public class ExecuteExternalScript {
    private Process scriptProcess;
    private String script;
    private long scriptPid;

    public ExecuteExternalScript() {

    }

    public ExecuteExternalScript(String script) {
        this.script = script;
    }

    public int getJvmPid() {
        String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        return Integer.parseInt(processName.split("@")[0]);
    }

    public void startScript() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(this.script);
        scriptProcess = processBuilder.start();
        this.scriptPid = scriptProcess.pid();
    }

    public void startScript(String script) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(script);
        scriptProcess = processBuilder.start();
        this.scriptPid = scriptProcess.pid();
    }

    public void stopScript(boolean sendSIGINT) {
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
