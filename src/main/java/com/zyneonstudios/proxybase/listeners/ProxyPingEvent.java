package com.zyneonstudios.proxybase.listeners;

import com.velocitypowered.api.event.EventTask;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.proxy.server.ServerPing;
import net.kyori.adventure.text.Component;

public class ProxyPingEvent {

    @Subscribe
    public EventTask onPing(com.velocitypowered.api.event.proxy.ProxyPingEvent e) {
        return EventTask.async(() -> this.doEvent(e));
    }

    private void doEvent(com.velocitypowered.api.event.proxy.ProxyPingEvent e) {
        final ServerPing.Builder ping = e.getPing().asBuilder();
        ping.description(Component.text("\n§f                                               ladevorgang§8..."));
        e.setPing(ping.build());
    }
}