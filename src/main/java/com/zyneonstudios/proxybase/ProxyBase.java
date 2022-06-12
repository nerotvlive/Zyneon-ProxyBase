package com.zyneonstudios.proxybase;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import com.zyneonstudios.proxybase.listeners.ProxyPingEvent;
import java.nio.file.Path;
import java.util.logging.Logger;

@Plugin(
        id = "proxybase",
        name = "ProxyBase",
        version = "1.0-SNAPSHOT",
        description = "Base plugin for zyneon proxy",
        url = "https://www.zyneonstudios.com",
        authors = {"nerotvlive"}
)
public class ProxyBase {

    private static ProxyServer server;
    private static Logger logger;
    private static Path dataDirectory;

    @Inject
    public ProxyBase(ProxyServer server, Logger logger, @DataDirectory Path dataDirectory) {
        ProxyBase.server = server;
        ProxyBase.logger = logger;
        ProxyBase.dataDirectory = dataDirectory;

    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        server.getEventManager().register(this, new ProxyPingEvent());
    }

    public static Logger getLogger() {
        return logger;
    }

    public static Path getDataDirectory() {
        return dataDirectory;
    }

    public static ProxyServer getServer() {
        return server;
    }

    public static void sendMessage(String message) {
        logger.info("[proxybase] "+message);
    }
}