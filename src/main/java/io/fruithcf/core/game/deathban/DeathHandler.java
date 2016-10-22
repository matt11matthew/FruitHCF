package io.fruithcf.core.game.deathban;

import io.fruithcf.core.lib.handler.Handler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Giovanni on 22-10-2016.
 * <p>
 * This file is part of the FruitHCF project.
 * Copyright (c) 2016 FruitHCF;www.vawke.io / development@vawke.io
 */
public class DeathHandler implements Handler.ListeningHandler
{
    @Override
    public void prepare()
    {
        //Game.getInstance().getServer().getPluginManager().registerEvents(this, Game.getInstance());
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event)
    {

    }
}
