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
public class WebUI {
    @XmlElement(name = "api_key")
    private String APIKey;
    @XmlElement(name = "listen")
    private String webAccess;
    @XmlElement(name = "login")
    private String login;
    @XmlElement(name = "password")
    private String pasword;

    public String getAPIKey() {
        return APIKey;
    }

    public void setAPIKey(final String APIKey) {
        this.APIKey = APIKey;
    }

    public String getWebAccess() {
        return webAccess;
    }

    public void setWebAccess(final String webAccess) {
        this.webAccess = webAccess;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(final String pasword) {
        this.pasword = pasword;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebUI webUI = (WebUI) o;

        if (!APIKey.equals(webUI.APIKey)) return false;
        if (!login.equals(webUI.login)) return false;
        if (!pasword.equals(webUI.pasword)) return false;
        if (!webAccess.equals(webUI.webAccess)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = APIKey.hashCode();
        result = 31 * result + webAccess.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + pasword.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("APIKey", APIKey).append("webAccess", webAccess).append("login", login).append("pasword", pasword).toString();
    }
}
