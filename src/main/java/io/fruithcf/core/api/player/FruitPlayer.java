package io.fruithcf.core.api.player;

import org.bukkit.Bukkit;

import java.util.UUID;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/21/2016 at 10:38 PM.
 */

public class FruitPlayer {

    private UUID uniqueId;
    private String name;

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }

    public boolean isOnline() {
        return Bukkit.getOfflinePlayer(uniqueId).isOnline();
    }

    public FruitPlayer(UUID uniqueId, String name) {
        this.uniqueId = uniqueId;
        this.name = name;
    }
}
