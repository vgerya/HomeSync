package com.mype.homesync.config;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ApplicationConfiguration {
    @XmlElement(name="storage_path")
    private String storagePath;
    @XmlElement(name = "use_gui")
    private boolean useGui;
    @XmlElement(name = "webui")
    private WebUI webui;

    public ApplicationConfiguration() {
    }

    public static ApplicationConfiguration createDefault() {
        final ApplicationConfiguration defaultConfig = new ApplicationConfiguration();
        defaultConfig.setStoragePath("config");
        defaultConfig.setUseGui(true);
        final WebUI webUI = new WebUI();
        webUI.setLogin("api");
        webUI.setPasword("secret");
        webUI.setWebAccess("127.0.0.1:19195");
        defaultConfig.setWebui(webUI);

        return defaultConfig;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(final String storagePath) {
        this.storagePath = storagePath;
    }

    public boolean isUseGui() {
        return useGui;
    }

    public void setUseGui(final boolean useGui) {
        this.useGui = useGui;
    }

    public WebUI getWebui() {
        return webui;
    }

    public void setWebui(final WebUI webui) {
        this.webui = webui;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationConfiguration that = (ApplicationConfiguration) o;

        if (useGui != that.useGui) return false;
        if (storagePath != null ? !storagePath.equals(that.storagePath) : that.storagePath != null) return false;
        if (!webui.equals(that.webui)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storagePath != null ? storagePath.hashCode() : 0;
        result = 31 * result + (useGui ? 1 : 0);
        result = 31 * result + webui.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("storagePath", storagePath).append("useGui", useGui).append("webui", webui).toString();
    }

}
