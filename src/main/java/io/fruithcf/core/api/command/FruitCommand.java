package io.fruithcf.core.api.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 9:55 AM.
 */
public interface FruitCommand extends CommandExecutor {

    @Override
    default boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        execute(sender, args);
        return true;
    }

    void execute(CommandSender sender, String[] args);
}
