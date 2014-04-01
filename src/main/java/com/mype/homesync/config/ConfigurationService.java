package com.mype.homesync.config;

import java.io.File;
import java.io.IOException;

/**
 * @author Vitaliy Gerya
 */
public interface ConfigurationService {
    static final ApplicationConfiguration DEFAULT_CONFIG = ApplicationConfiguration.createDefault();

    File getConfigurationFile();

    void save(ApplicationConfiguration config) throws IOException;

    ApplicationConfiguration load() throws IOException;

    void setConfigurationDir(File file);
}
