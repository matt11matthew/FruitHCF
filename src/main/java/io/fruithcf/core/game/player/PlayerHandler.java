package io.fruithcf.core.game.player;

import io.fruithcf.core.Game;
import io.fruithcf.core.api.player.FruitPlayer;
import io.fruithcf.core.lib.file.FruitYAML;
import io.fruithcf.core.lib.handler.Handler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 9:15 AM.
 */
public class PlayerHandler implements Handler.ListeningHandler {

    private Logger logger;
    private FruitYAML fruitYAML;
    private ConcurrentHashMap<String, UUID> playerUUIDCache;
    private ConcurrentHashMap<UUID, FruitPlayer> playerCache;

    @Override
    public void prepare() {
        this.logger = Logger.getLogger(getClass().getSimpleName());
        this.playerUUIDCache = new ConcurrentHashMap<>();
        this.playerCache = new ConcurrentHashMap<>();

        fruitYAML = new FruitYAML(getClass().getSimpleName(), true);
        if (fruitYAML.isNewFile()) {
            fruitYAML.getFileConfiguration().set("playerCache.test.uuid", "test");
            fruitYAML.save();
        }
        fruitYAML.getFileConfiguration().getConfigurationSection("playerCache").getKeys(true).forEach(name -> {
            UUID uuid = UUID.fromString(fruitYAML.getFileConfiguration().getString("playerCache." + name + ".uuid"));
            playerUUIDCache.put(name, uuid);
        });
    }

    public void save() {
        playerUUIDCache.keySet().forEach(name -> {
            fruitYAML.getFileConfiguration().set("playerCache." + name + ".uuid", playerUUIDCache.get(name).toString());
            fruitYAML.save();
        });
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent e) {
        if (!playerUUIDCache.containsKey(e.getName())) {
            playerUUIDCache.put(e.getName(), e.getUniqueId());
        }
        File file = new File(Game.getInstance().getDataFolder() + "/playerdata/", e.getUniqueId().toString() + ".yml");
        FruitYAML yaml = new FruitYAML(file);
        FruitPlayer player = (yaml.isNewFile()) ? new FruitPlayer(e.getUniqueId(), e.getName(), true) : new FruitPlayer(e.getUniqueId(), e.getName(), false);
        playerCache.put(e.getUniqueId(), player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        playerCache.get(e.getPlayer().getUniqueId()).save();
        playerCache.remove(e.getPlayer().getUniqueId());
    }

    public FruitPlayer getPlayer(UUID uuid) {
        return playerCache.get(uuid);
    }

    public FruitPlayer getPlayer(String name) {
        return getPlayer(playerUUIDCache.get(name));
    }
}