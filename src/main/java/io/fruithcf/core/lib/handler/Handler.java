package io.fruithcf.core.lib.handler;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/21/2016 at 6:35 PM.
 */
public interface Handler
{
    void prepare();

    interface ListeningHandler extends Handler, Listener
    {
        default void cancel(Event event)
        {
            event.getHandlers().unregister(this);
        }
    }
}
