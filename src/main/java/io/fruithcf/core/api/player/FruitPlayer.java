package io.fruithcf.core.api.player;

import io.fruithcf.core.Game;
import io.fruithcf.core.api.faction.Faction;
import io.fruithcf.core.lib.prompt.Prompt;
import io.fruithcf.core.lib.utils.string.StringUtils;
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
    private int lives;
    private Faction faction;
    private int kills;
    private int deaths;

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

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void msg(String msg) {
        Game.getInstance().getServer().getPlayer(uniqueId).sendMessage(StringUtils.colorCodes(msg));
    }

    public void sendCenterMessage(String[] msg) {
        Prompt.sendCenteredMessage(Bukkit.getPlayer(uniqueId), msg);
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
}
