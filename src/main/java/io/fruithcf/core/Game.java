package io.fruithcf.core;

import io.fruithcf.core.api.handler.HandlerManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Giovanni on 21-10-2016.
 * <p>
 * This file is part of the FruitHCF project.
 * Copyright (c) 2016 FruitHCF;www.vawke.io / development@vawke.io
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
        handlerManager.registerHandler(null);
    }

    public static Game getInstance() {
        return instance;
    }

    public HandlerManager getHandlerManager() {
        return handlerManager;
    }
}
