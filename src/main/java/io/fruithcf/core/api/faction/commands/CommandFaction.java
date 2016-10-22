package io.fruithcf.core.api.faction.commands;

import io.fruithcf.core.api.command.FruitCommand;
import io.fruithcf.core.api.faction.FactionManager;
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
        try {
            switch (args[0]) {
                case "who":
                    if (Bukkit.getPlayer(args[1]) != null) {
                        //PLAYER F WHO
                    } else if (FactionManager.getInstance().isFaction(args[1])) {
                        //FACTION F WHO
                    }
            }
        } catch (Exception e) {
            return;
        }
    }
}
