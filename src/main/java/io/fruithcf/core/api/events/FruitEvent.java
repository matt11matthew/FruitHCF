package io.fruithcf.core.api.events;

import org.bukkit.event.Event;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 11:29 AM.
 */
public abstract class FruitEvent extends Event {

    public FruitEvent(boolean async) {
        super(async);
    }
}
