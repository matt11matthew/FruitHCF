package io.fruithcf.core.api.player;

import io.fruithcf.core.Game;
import io.fruithcf.core.api.faction.Faction;
import io.fruithcf.core.api.faction.FactionManager;
import io.fruithcf.core.lib.exceptions.FactionNotFoundException;
import io.fruithcf.core.lib.file.FruitYAML;
import io.fruithcf.core.lib.prompt.Prompt;
import io.fruithcf.core.lib.utils.string.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
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
    private boolean newPlayer;
    private FruitYAML playerYAML;

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }

    public boolean isOnline() {
        return Bukkit.getOfflinePlayer(uniqueId).isOnline();
    }

    public FruitPlayer(UUID uniqueId, String name, boolean newPlayer) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.newPlayer = newPlayer;
        File file = new File(Game.getInstance().getDataFolder() + "/playerdata/", uniqueId.toString() + ".yml");
        this.playerYAML = new FruitYAML(file);
        if (newPlayer) {
            this.lives = 0;
            this.deaths = 0;
            this.kills = 0;
            this.faction = null;
            save();
        } else {
            load();
        }
    }

    public void save() {
        this.playerYAML.getFileConfiguration().set("id", uniqueId.toString());
        this.playerYAML.getFileConfiguration().set("username", name);
        this.playerYAML.getFileConfiguration().set("lives", lives);
        this.playerYAML.getFileConfiguration().set("kills", kills);
        this.playerYAML.getFileConfiguration().set("deaths", deaths);
        this.playerYAML.getFileConfiguration().set("faction", (faction == null) ? "none" : faction.getName());
        this.playerYAML.save();
    }

    public void load() {
        FileConfiguration config = this.playerYAML.getFileConfiguration();
        this.lives = config.getInt("lives");
        this.deaths = config.getInt("deaths");
        this.kills = config.getInt("kills");
        try {
            this.faction = FactionManager.getInstance().getFaction(name);
        } catch (FactionNotFoundException e) {
           this.faction = null;
        }
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

    public boolean isNewPlayer() {
        return newPlayer;
    }

    public FruitYAML getPlayerYAML() {
        return playerYAML;
    }
}
