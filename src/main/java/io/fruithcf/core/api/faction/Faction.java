package io.fruithcf.core.api.faction;

import io.fruithcf.core.Game;
import io.fruithcf.core.api.player.FruitPlayer;
import io.fruithcf.core.lib.file.FruitYAML;
import lombok.Data;
import org.bukkit.Location;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 9:04 AM.
 */
@Data
public class Faction {

    private List<FruitPlayer> members;
    private FruitPlayer leader;
    private Location factionHome;
    private UUID uniqueId;
    private String name;
    private double dtr;

    public Faction() {

    }

    public void save() {
        FruitYAML fruitYAML = new FruitYAML(new File(Game.getInstance().getDataFolder() + File.separator + "factions" + File.separator, getUniqueId().toString()));
        fruitYAML.getFileConfiguration().set("id", uniqueId.toString());
        fruitYAML.getFileConfiguration().set("name", name);
        fruitYAML.getFileConfiguration().set("dtr", dtr);
        if (factionHome != null) {
            fruitYAML.getFileConfiguration().set("home.world", factionHome.getWorld().getName());
            fruitYAML.getFileConfiguration().set("home.x", factionHome.getX());
            fruitYAML.getFileConfiguration().set("home.y", factionHome.getY());
            fruitYAML.getFileConfiguration().set("home.z", factionHome.getZ());
        }
        fruitYAML.getFileConfiguration().set("leader", leader.getUniqueId().toString());
        List<String> member = new ArrayList<>();
        members.forEach(fruitPlayer -> {
            member.add(fruitPlayer.getUniqueId().toString());
        });
        fruitYAML.getFileConfiguration().set("members", member);
        fruitYAML.save();
    }
}
