package io.fruithcf.core.api.handler.handlers.player;

import io.fruithcf.core.api.handler.Handler;

import java.util.logging.Logger;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/21/2016 at 10:14 PM.
 */
public class PlayerHandler implements Handler {

    private Logger logger;

    @Override
    public void onLoad() {
        logger = Logger.getLogger("[" + getClass().getSimpleName() + "]");
    }

    @Override
    public void onUnload() {

    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public boolean listener() {
        return true;
    }
}
