package com.mype.homesync.config;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.contentOf;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * // path to folder where Sync will store its internal data, folder must exist on disk
 * "storage_path" : "/Users/user/.SyncAPI",
 * <p>
 * // run Sync in GUI-less mode
 * "use_gui" : false,
 * <p>
 * "webui" : {
 * // IP address and port to access HTTP API
 * "listen" : "127.0.0.1:8888",
 * // login and password for HTTP basic authentication authentication is optional, but it's recommended to use some
 * // secret values unique for each Sync installation
 * "login" : "api",
 * "password" : "secret",
 * // replace xxx with API key received from BitTorrent
 * "api_key" : "xxx"
 * }
 *
 * @author Vitaliy Gerya
 */
public class ConfigurationServiceImplShould {
    @Rule
    public TemporaryFolder tempDir = new TemporaryFolder();

    private ConfigurationService service;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        service = new ConfigurationServiceImpl();
        File file = tempDir.newFolder();
        service.setConfigurationDir(file);
    }

    @Test
    public void saveConfiguration() throws Exception {
        ApplicationConfiguration config = new ApplicationConfiguration();
        config.setStoragePath("STORAGE_PATH");
        config.setUseGui(false);

        WebUI webUI = new WebUI();
        webUI.setWebAccess("127.0.0.1:8888");
        webUI.setLogin("api");
        webUI.setPasword("secret");
        webUI.setAPIKey("xxx");
        config.setWebui(webUI);
        service.save(config);

        assertThat(service.getConfigurationFile()).exists().isFile();
        assertThat(contentOf(service.getConfigurationFile())).
                contains("\"storage_path\" : \"STORAGE_PATH\"").
                contains("\"use_gui\" : false").
                contains("\"webui\" : {").
                contains("\"listen\" : \"127.0.0.1:8888\"").
                contains("\"login\" : \"api\"").
                contains("\"password\" :" + " \"secret\"").
                contains("\"api_key\" : \"xxx\"");

    }

    @Test
    public void loadConfigurationFromFile() throws Exception {
        final String content = "{\n" +
                "    \"storage_path\" : \"STORAGE_PATH\",\n" +
                "    \"use_gui\" : false,\n" +
                "    \"webui\" : {\n" +
                "        \"listen\" : \"127.0.0.1:8888\",\n" +
                "        \"login\" : \"api\",\n" +
                "        \"password\" : \"secret\",\n" +
                "        \"api_key\" : \"xxx\"\n" +
                "     }\n" +
                "}";
        File file = service.getConfigurationFile();
        try(FileWriter writer = new FileWriter(file)){
            writer.write(content);
            writer.flush();
        }

        ApplicationConfiguration expectedConfig = new ApplicationConfiguration();
        expectedConfig.setStoragePath("STORAGE_PATH");
        expectedConfig.setUseGui(false);

        WebUI webUI = new WebUI();
        webUI.setWebAccess("127.0.0.1:8888");
        webUI.setLogin("api");
        webUI.setPasword("secret");
        webUI.setAPIKey("xxx");
        expectedConfig.setWebui(webUI);

        ApplicationConfiguration config = service.load();

        assertThat(config).isEqualsToByComparingFields(expectedConfig);
    }

    @Test
    public void ifConfigurationFileIsNotExistsCreteDefault() throws Exception {
        ApplicationConfiguration firstLoadConfig = service.load();
        assertThat(firstLoadConfig).isNotNull();
    }


}
