package io.fruithcf.core;

import io.fruithcf.core.api.handler.HandlerManager;
import io.fruithcf.core.api.handler.handlers.deathban.DeathBanHandler;
import io.fruithcf.core.api.handler.handlers.player.PlayerHandler;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Giovanni on 21-10-2016.
 *
 * This file is part of the FruitHCF project.
 * Copyright (c) 2016 FruitHCF;www.vawke.io / development@vawke.io
 */

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 *
 * Created by Matthew E on 10/21/2016 at 6:50 PM.
 */
public class Game extends JavaPlugin {

    private static Game instance;
    private HandlerManager handlerManager;

    @Override
    public void onEnable() {
        instance = this;
        handlerManager = new HandlerManager();
        registerHandlers();
        handlerManager.loadHandlers();
    }

    @Override
    public void onDisable() {
        handlerManager.unloadHandlers();
    }

    private void registerHandlers() {
        handlerManager.registerHandler(new PlayerHandler());
        handlerManager.registerHandler(new DeathBanHandler());
    }

    public static Game getInstance() {
        return instance;
    }

    public HandlerManager getHandlerManager() {
        return handlerManager;
    }
}
