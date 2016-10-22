package io.fruithcf.core.game.enderpearl;

import com.google.common.collect.Maps;
import io.fruithcf.core.Game;
import io.fruithcf.core.lib.handler.Handler;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Giovanni on 22-10-2016.
 * <p>
 * This file is part of the FruitHCF project.
 * Copyright (c) 2016 FruitHCF;www.vawke.io / development@vawke.io
 */
public class EnderpearlHandler implements Handler.ListeningHandler
{
    private HashMap<UUID, Player> playerMap;

    private int cooldown = 10; //TODO get from handler file

    @Override
    public void prepare()
    {
        //Game.getInstance().getServer().getPluginManager().registerEvents(this, Game.getInstance());
        this.playerMap = Maps.newHashMap();
    }

    @EventHandler
    public void onThrow(ProjectileLaunchEvent event)
    {
        if ((event.getEntity().getShooter() instanceof Player) && (event.getEntity().getType() == EntityType.ENDER_PEARL))
        {
            if (this.playerMap.containsKey(event.getEntity().getShooter()))
                event.setCancelled(true);
            else Game.getInstance().getServer().getScheduler().scheduleAsyncDelayedTask(Game.getInstance(), () -> {
                this.playerMap.remove(event.getEntity().getShooter());
            }, (20L * this.cooldown));
        }
    }
}
