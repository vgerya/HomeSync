package com.mype.homesync.bt;

import java.io.IOException;

import com.mype.homesync.config.ConfigurationService;

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

    public BitTorrentDaemon() {
    }

    public void start() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();

        final String osName = System.getProperty("os.name");
        final String configParameterName;
        if (osName.contains("Win")) {
            configParameterName = "/config";
        } else {
            configParameterName = "--config";
        }

        processBuilder = processBuilder.command(environment.getPathBTExecutable().getAbsolutePath(), configParameterName, configurationService.getConfigurationFile().getAbsolutePath());
        processBuilder.start();

    }

    public void stop() {

    }

    public static void main(String[] args) throws IOException {
        new BitTorrentDaemon().start();
    }
}
