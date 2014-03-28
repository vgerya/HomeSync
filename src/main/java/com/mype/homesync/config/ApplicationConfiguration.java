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
    @XmlElement(name = "storage_path")
    private String storagePath;
    @XmlElement(name = "use_gui")
    private boolean useGui;
    @XmlElement(name = "webui")
    private WebUI webui;

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
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("storagePath", storagePath).append("useGui", useGui).append("webui", webui).toString();
    }
}
