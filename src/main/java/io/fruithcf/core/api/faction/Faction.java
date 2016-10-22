package io.fruithcf.core.api.faction;

import io.fruithcf.core.api.player.FruitPlayer;
import org.bukkit.Location;

import java.util.List;
import java.util.UUID;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 9:04 AM.
 */
public class Faction {

    private List<FruitPlayer> members;
    private FruitPlayer leader;
    private Location factionHome;
    private UUID uniqueId;
    private String name;

}
