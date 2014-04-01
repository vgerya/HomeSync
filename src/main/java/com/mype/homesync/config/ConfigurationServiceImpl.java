package com.mype.homesync.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.google.inject.Inject;
import com.mype.homesync.bt.Environment;

import java.io.File;
import java.io.IOException;


/**
 * @author Vitaliy Gerya
 */
public class ConfigurationServiceImpl implements ConfigurationService {
    public static final String CONFIGURATION_FILE_NAME = ".homesyncconfig";

    @Inject
    private Environment environment;

    private File configurationDir;
    private File configurationFile;
    private final ObjectMapper mapper = new ObjectMapper();

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

    @Override
    public File getConfigurationFile() {
        return this.configurationFile;
    }

    @Override
    public void save(final ApplicationConfiguration config) throws IOException {
        mapper.writeValue(configurationFile, config);
    }

    @Override
    public ApplicationConfiguration load() throws IOException {
        if(!configurationFile.exists()) {
            ApplicationConfiguration defaultAppconfig = ApplicationConfiguration.createDefault();
            defaultAppconfig.getWebui().setAPIKey(environment.getAPIKey());
        }
        return mapper.readValue(configurationFile, ApplicationConfiguration.class);
    }
}
