package io.fruithcf.core;

import io.fruithcf.core.game.deathban.DeathHandler;
import io.fruithcf.core.game.enderpearl.EnderpearlHandler;
import io.fruithcf.core.lib.handler.Handler;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Giovanni on 22-10-2016.
 * <p>
 * This file is part of the FruitHCF project.
 * Copyright (c) 2016 FruitHCF;www.vawke.io / development@vawke.io
 */
public class HandlerCore implements Handler
{
    private ConcurrentHashMap<String, Handler> handlerMap;

    @Override
    public void prepare()
    {
        this.handlerMap = new ConcurrentHashMap<>();

        this.handlerMap.put("DeathbanHandler", new DeathHandler());
        this.handlerMap.put("EnderpearlHandler", new EnderpearlHandler());

        handlerMap.values().forEach((handler) -> handler.prepare());
    }
}
