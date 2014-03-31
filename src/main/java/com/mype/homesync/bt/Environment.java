package com.mype.homesync.bt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Vitaliy Gerya
 */
public class Environment {
    private final File buildProperties = new File("~/homesync-build.properties");

    public Environment() {
    }

    private Properties readProperties() throws IOException {
        final Properties properties = new Properties();
        properties.clear();
        try(FileInputStream fis = new FileInputStream(buildProperties)) {
            properties.load(fis);
        }

        return properties;
    }

    public File getPathBTExecutable( ) throws IOException {
        return new File(readProperties().getProperty("btsync.executable.path"));
    }
}
