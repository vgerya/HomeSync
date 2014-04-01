package com.mype.homesync.bt;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.mype.homesync.config.ConfigurationService;
import com.mype.homesync.config.ConfigurationServiceImpl;

/**
 * @author Vitaliy Gerya
 */
public class BitTorrentModule extends AbstractModule{
    @Override
    protected void configure() {
        //TODO implement it
        bind(Environment.class).to(EnvironmentImpl.class).in(Scopes.SINGLETON);
        bind(ConfigurationService.class).to(ConfigurationServiceImpl.class);
    }
}
