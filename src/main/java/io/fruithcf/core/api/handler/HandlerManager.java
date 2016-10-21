package io.fruithcf.core.api.handler;

import com.google.common.collect.Maps;
import io.fruithcf.core.Game;
import org.bukkit.Bukkit;

import java.util.Map;
import java.util.logging.Level;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 *
 * Created by Matthew E on 10/21/2016 at 6:36 PM.
 */
public class HandlerManager {

    private Map<String, Handler> handlers;
    private static HandlerManager instance;

    public HandlerManager() {
        handlers = Maps.newHashMap();
        instance = this;
    }

    public static HandlerManager getInstance() {
        return instance;
    }

    public void loadHandlers() {
        handlers.values().forEach(handler -> {
            handler.onLoad();
            if (handler.listener()) {
                Bukkit.getPluginManager().registerEvents(handler, Game.getInstance());
            }
            handler.getLogger().log(Level.INFO, " Loaded");
        });
    }

    public void unloadHandlers() {
        handlers.values().forEach(handler -> {
            handler.onUnload();
            handler.getLogger().log(Level.INFO, " Unloaded");
        });
    }

    public void registerHandler(Handler handler) {
        handlers.put(handler.getClass().getSimpleName(), handler);
    }
}
