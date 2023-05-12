package com.github.nexmark.flink.perf;

import java.io.IOException;

public class ExecuteExternalScript {

    Process scriptProcess;
    String script;

    public ExecuteExternalScript() {
        System.out.println("Initializing script executor");
    }

    public ExecuteExternalScript(String script) {
        System.out.println("Initializing script executor with script:" + script);
        this.script = script;
    }

    public void startScript(String script) throws IOException {
        System.out.println("Start executing script " + script);
        ProcessBuilder processBuilder = new ProcessBuilder("/usr/bin/bash", "-c", script);
        this.scriptProcess = processBuilder.start();
    }

    public void startScript() throws IOException {
        System.out.println("Start executing script " + this.script);
        if (this.script == null) {
            // Throws exception
            throw new IOException("Script is null, do nothing");
        }
        ProcessBuilder processBuilder = new ProcessBuilder("/usr/bin/bash", "-c", this.script);
        this.scriptProcess = processBuilder.start();
    }

    public void stopScript(boolean sendSIGINT) {
        scriptProcess.destroy();
    }
}
