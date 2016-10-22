package io.fruithcf.core.api.faction;

import io.fruithcf.core.Game;
import io.fruithcf.core.api.player.FruitPlayer;
import io.fruithcf.core.lib.exceptions.FactionNotFoundException;
import io.fruithcf.core.lib.file.FruitYAML;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 9:38 AM.
 */
public class FactionManager {

    private ConcurrentHashMap<UUID, Faction> factionMap;
    private static FactionManager instance;

    public FactionManager() {
        this.factionMap = new ConcurrentHashMap<>();
    }

    public boolean isFaction(String name) {
        for (Faction faction : factionMap.values()) {
            return (faction.getName().equals(name));
        }
        return false;
    }

    public Faction getFaction(String name) throws FactionNotFoundException {
        for (Faction faction : factionMap.values()) {
            if (faction.getName().equals(name)) {
                return faction;
            }
        }
        throw new FactionNotFoundException();
    }

    public void createFaction(String name, FruitPlayer leader) {
        if (isFaction(name)) {
            return;
        }
        UUID id = UUID.randomUUID();
        Faction faction = new Faction();
        faction.setUniqueId(id);
        faction.setName(name);
        faction.setDtr(1.0D);
        faction.setFactionHome(null);
        faction.setLeader(leader);
        faction.setMembers(null);
        factionMap.put(id, faction);

        FruitYAML fruitYAML = new FruitYAML(new File(Game.getInstance().getDataFolder() + File.separator + "factions" + File.separator, faction.getUniqueId().toString()));
        fruitYAML.getFileConfiguration().set("id", id.toString());
        fruitYAML.getFileConfiguration().set("name", name);
        fruitYAML.getFileConfiguration().set("dtr", faction.getDtr());
        fruitYAML.getFileConfiguration().set("home", null);
        fruitYAML.getFileConfiguration().set("leader", leader.getUniqueId().toString());
        fruitYAML.getFileConfiguration().set("members", null);
        fruitYAML.save();
    }

    public static FactionManager getInstance() {
        if (instance == null) {
            instance = new FactionManager();
        }
        return instance;
    }
}
