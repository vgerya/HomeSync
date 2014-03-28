package com.mype.homesync.config;

import org.junit.Test;

/**
 * @author Vitaliy Gerya
 */
public class ApplicationConfigurationShould {
    private ApplicationConfiguration config;
    @Test
    public void createConfiguration() throws Exception {
        config = new ApplicationConfiguration();
        config.setStoragePath("path");
        config.setUseGui(false);

        WebUI webUI = new WebUI();
        webUI.setWebAccess("127.0.0.1:8888");
        webUI.setLogin("api");
        webUI.setPasword("secret");
        webUI.setAPIKey("vd98b76d98b76d98gh7ds9g87fg8dsfg798dsg798g7dsfg89sdf");
        config.setWebui(webUI);
    }
}
