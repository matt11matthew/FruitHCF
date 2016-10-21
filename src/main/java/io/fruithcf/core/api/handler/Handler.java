package io.fruithcf.core.api.handler;

import org.bukkit.event.Listener;

import java.util.logging.Logger;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 *
 * Created by Matthew E on 10/21/2016 at 6:35 PM.
 */
public interface Handler extends Listener {

    void onLoad();

    void onUnload();

    Logger getLogger();

    boolean listener();
}
