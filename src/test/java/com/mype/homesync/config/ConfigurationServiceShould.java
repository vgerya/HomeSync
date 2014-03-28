package com.mype.homesync.config;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * // path to folder where Sync will store its internal data, folder must exist on disk
 "storage_path" : "/Users/user/.SyncAPI",

 // run Sync in GUI-less mode
 "use_gui" : false,

 "webui" : {
 // IP address and port to access HTTP API
 "listen" : "127.0.0.1:8888",
 // login and password for HTTP basic authentication authentication is optional, but it's recommended to use some
 // secret values unique for each Sync installation
 "login" : "api",
 "password" : "secret",
 // replace xxx with API key received from BitTorrent
 "api_key" : "xxx"
 }
 * @author Vitaliy Gerya
 */
public class ConfigurationServiceShould {
    @Rule
    public TemporaryFolder tempDir = new TemporaryFolder();

    private ConfigurationService service;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        service = new ConfigurationService();
    }

    @Test
    public void storeConfiguration() throws Exception {
        File file = tempDir.newFolder();
        service.setConfigurationDir(file);


        ApplicationConfiguration config = new ApplicationConfiguration();
        config.setStoragePath("STORAGE_PATH");
        config.setUseGui(false);

        WebUI webUI = new WebUI();
        webUI.setWebAccess("127.0.0.1:8888");
        webUI.setLogin("api");
        webUI.setPasword("secret");
        webUI.setAPIKey("vd98b76d98b76d98gh7ds9g87fg8dsfg798dsg798g7dsfg89sdf");
        config.setWebui(webUI);
        service.save(config);

        assertThat(new File(file, service.CONFIGURATION_FILE_NAME)).exists().isFile(). hasContent
                ("\"storage_path\" : " +
                "\"STORAGE_PATH\"");
    }


}
