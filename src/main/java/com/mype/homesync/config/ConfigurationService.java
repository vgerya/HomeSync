package com.mype.homesync.config;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import java.io.File;
import java.io.IOException;

import static org.codehaus.jackson.map.SerializationConfig.Feature.USE_ANNOTATIONS;

/**
 * @author Vitaliy Gerya
 */
public class ConfigurationService {
    public static final String CONFIGURATION_FILE_NAME = ".homesyncconfig";


    private ObjectMapper mapper = new ObjectMapper();

    {
//        mapper.getDeserializationConfig().setAnnotationIntrospector(new org.codehaus.jackson.xc.JaxbAnnotationIntrospector());
//        mapper.getSerializationConfig().setAnnotationIntrospector(new org.codehaus.jackson.xc.JaxbAnnotationIntrospector());
        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
        // make deserializer use JAXB annotations (only)
        mapper.getDeserializationConfig().setAnnotationIntrospector(introspector);
        // make serializer use JAXB annotations (only)
        mapper.getSerializationConfig().setAnnotationIntrospector(introspector);
        mapper.getSerializationConfig().set(USE_ANNOTATIONS, false);
    }

    private File configurationDir;

    public void setConfigurationDir(final File configurationDir) {
        this.configurationDir = configurationDir;
    }

    public File getConfigurationDir() {
        return configurationDir;
    }

    public void save(final ApplicationConfiguration config) throws IOException {
        mapper.writeValue(new File(configurationDir, CONFIGURATION_FILE_NAME), config);
    }
}
