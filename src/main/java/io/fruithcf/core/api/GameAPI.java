package io.fruithcf.core.api;

import io.fruithcf.core.HandlerCore;
import io.fruithcf.core.api.player.FruitPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 11:06 AM.
 */
public class GameAPI {

    public static FruitPlayer getFruitPlayer(UUID uuid) {
        return HandlerCore.getPlayerHandler().getPlayer(uuid);
    }

    public static FruitPlayer getFruitPlayer(String name) {
        return HandlerCore.getPlayerHandler().getPlayer(name);
    }

    public static FruitPlayer getFruitPlayer(Player player) {
        return HandlerCore.getPlayerHandler().getPlayer(player.getUniqueId());
    }
}
