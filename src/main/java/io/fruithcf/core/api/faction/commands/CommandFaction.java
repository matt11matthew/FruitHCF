package io.fruithcf.core.api.faction.commands;

import io.fruithcf.core.api.command.FruitCommand;
import io.fruithcf.core.api.faction.Faction;
import io.fruithcf.core.api.faction.FactionManager;
import io.fruithcf.core.lib.exceptions.FactionNotFoundException;
import io.fruithcf.core.lib.utils.string.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 9:55 AM.
 */
public class CommandFaction implements FruitCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        switch (args[0]) {
            case "who":
                if (Bukkit.getPlayer(args[1]) != null) {
                    //PLAYER F WHO
                    break;
                } else if (FactionManager.getInstance().isFaction(args[1])) {
                    //FACTION F WHO
                    try {
                        Faction faction = FactionManager.getInstance().getFaction(args[1]);
                        
                        break;
                    } catch (FactionNotFoundException e) {
                        sender.sendMessage(StringUtils.colorCodes("&cCould not find faction!"));
                        break;
                    }
                }
                break;
        }
    }
}