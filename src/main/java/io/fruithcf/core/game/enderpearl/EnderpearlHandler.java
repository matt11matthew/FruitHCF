package io.fruithcf.core.game.enderpearl;

import com.google.common.collect.Maps;
import io.fruithcf.core.Game;
import io.fruithcf.core.lib.file.FruitYAML;
import io.fruithcf.core.lib.handler.Handler;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by Giovanni on 22-10-2016.
 * <p>
 * This file is part of the FruitHCF project.
 * Copyright (c) 2016 FruitHCF;www.vawke.io / development@vawke.io
 */
public class EnderpearlHandler implements Handler.ListeningHandler {
    private HashMap<UUID, Player> playerMap;
    private FruitYAML fruitYAML;
    private int cooldown;
    private Logger logger;

    @Override
    public void prepare() {
        this.logger = Logger.getLogger(getClass().getSimpleName());

        this.playerMap = Maps.newHashMap();

        fruitYAML = new FruitYAML(getClass().getSimpleName(), true);
        if (fruitYAML.isNewFile()) {
            fruitYAML.getFileConfiguration().set("cooldown", 10);
            fruitYAML.save();
        }
        this.cooldown = fruitYAML.getFileConfiguration().getInt("cooldown");

    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @EventHandler
    public void onThrow(ProjectileLaunchEvent event) {
        if ((event.getEntity().getShooter() instanceof Player) && (event.getEntity().getType() == EntityType.ENDER_PEARL)) {
            if (cooldown == 0) {
                return;
            }
            if (this.playerMap.containsKey(event.getEntity().getShooter()))
                event.setCancelled(true);
            else Game.getInstance().getServer().getScheduler().scheduleAsyncDelayedTask(Game.getInstance(), () -> {
                this.playerMap.remove(event.getEntity().getShooter());
            }, (20L * this.cooldown));
        }
    }
}