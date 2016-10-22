package io.fruithcf.core;

import io.fruithcf.core.game.deathban.DeathHandler;
import io.fruithcf.core.game.enderpearl.EnderpearlHandler;
import io.fruithcf.core.lib.handler.Handler;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 8:04 AM.
 */

/**
 * Created by Giovanni on 22-10-2016.
 * <p>
 * This file is part of the FruitHCF project.
 * Copyright (c) 2016 FruitHCF;www.vawke.io / development@vawke.io
 */
public class HandlerCore implements Handler {

    private ConcurrentHashMap<String, Handler> handlerMap;

    @Override
    public void prepare() {
        this.handlerMap = new ConcurrentHashMap<>();

        registerHandler(new EnderpearlHandler());
        registerHandler(new DeathHandler());

        handlerMap.values().forEach(handler -> {
            try {
                handler.prepare();
                handler.getLogger().log(Level.INFO, " has been loaded");
            } catch (Exception e) {
                handler.getLogger().log(Level.WARNING, " could not load " + handler.getClass().getName());
                e.printStackTrace();
            }
        });
    }


    private void registerHandler(Handler handler) {
        handlerMap.put(handler.getClass().getSimpleName(), handler);
        if (handler instanceof ListeningHandler) {
            ListeningHandler listener = (ListeningHandler) handler;
            Game.getInstance().getServer().getPluginManager().registerEvents(listener, Game.getInstance());
        }
    }
}
