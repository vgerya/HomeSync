package com.mype.homesync.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import java.io.File;
import java.io.IOException;


/**
 * @author Vitaliy Gerya
 */
public class ConfigurationService {
    public static final String CONFIGURATION_FILE_NAME = ".homesyncconfig";

    private File configurationDir;
    private File configurationFile;
    private ObjectMapper mapper = new ObjectMapper();

    {
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        mapper.registerModule(module);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    public void setConfigurationDir(final File configurationDir) {
        this.configurationDir = configurationDir;
        this.configurationFile = new File(configurationDir, CONFIGURATION_FILE_NAME);
    }

    public File getConfigurationDir() {
        return configurationDir;
    }

    public void save(final ApplicationConfiguration config) throws IOException {
        mapper.writeValue(configurationFile, config);
    }
}
