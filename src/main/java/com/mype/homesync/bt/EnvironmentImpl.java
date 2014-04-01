package com.mype.homesync.bt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Vitaliy Gerya
 */
public class EnvironmentImpl implements Environment {
    private final File buildProperties = new File("~/homesync-build.properties");

    public EnvironmentImpl() {
    }

    private Properties readProperties() {
        final Properties properties = new Properties();
        properties.clear();
        try (FileInputStream fis = new FileInputStream(buildProperties)) {
            properties.load(fis);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    @Override
    public File getPathBTExecutable() throws IOException {
        return new File(readProperties().getProperty("btsync.executable.path"));
    }

    @Override
    public String getAPIKey() {
        return readProperties().getProperty("btsync.secret.key");
    }
}
