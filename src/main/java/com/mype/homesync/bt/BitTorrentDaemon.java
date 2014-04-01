package com.mype.homesync.bt;

import com.mype.homesync.config.ConfigurationService;

import java.io.IOException;

/**
 * On Mac and Linux, run the Sync executable with --config path_to_file argument.
 * On Windows, use /config path_to_file.
 * The config file may be located in any directory on your drive.
 *
 * @author Vitaliy Gerya
 */
public class BitTorrentDaemon {
    private Environment environment = new Environment();
    private ConfigurationService configurationService = new ConfigurationService();

    private Process process;

    public BitTorrentDaemon() {
    }

    public void start() throws IOException {
        if (process != null) return;

        ProcessBuilder processBuilder = new ProcessBuilder();

        final String osName = System.getProperty("os.name");
        final String configParameterName;
        if (osName.contains("Win")) {
            configParameterName = "/config";
        } else {
            configParameterName = "--config";
        }

        processBuilder = processBuilder.command(environment.getPathBTExecutable().getAbsolutePath(), configParameterName, configurationService.getConfigurationFile().getAbsolutePath());
        process = processBuilder.start();
    }

    public void stop() {
        if (process == null) return;

        process.destroy();
        process = null;
    }

    public void status() {
        if (process == null)
            System.out.println("Process is not alive.");
        else
            System.out.println("Process is alive.");
    }

    public static void main(String[] args) throws IOException {
        new BitTorrentDaemon().start();
    }
}
