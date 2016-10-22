package io.fruithcf.core.api.handler.handlers.server;

import io.fruithcf.core.api.handler.Handler;
import io.fruithcf.core.api.utils.StringUtils;
import org.bukkit.Bukkit;

import java.util.logging.Logger;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/21/2016 at 10:28 PM.
 */
public class ServerHandler implements Handler {

    private Logger logger;

    @Override
    public void onLoad() {
        logger = Logger.getLogger("[" + getClass().getSimpleName() + "]");
    }

    @Override
    public void onUnload() {
        stop();
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public boolean listener() {
        return false;
    }

    public void stop() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.kickPlayer(StringUtils.colorCodes("&a&lThe Server is Rebooting\n&7Please wait..."));
        });
    }
}
