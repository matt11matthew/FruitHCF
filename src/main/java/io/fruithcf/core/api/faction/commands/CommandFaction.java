package io.fruithcf.core.api.faction.commands;

import io.fruithcf.core.api.GameAPI;
import io.fruithcf.core.api.command.FruitCommand;
import io.fruithcf.core.api.faction.Faction;
import io.fruithcf.core.api.faction.FactionManager;
import io.fruithcf.core.api.player.FruitPlayer;
import io.fruithcf.core.lib.exceptions.FactionNotFoundException;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 9:55 AM.
 */
public class CommandFaction implements FruitCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            FruitPlayer fp = GameAPI.getFruitPlayer(player);
            switch (args[0]) {
                case "invite":
                    break;
                case "kick":
                    break;
                case "quit":
                case "leave":
                    break;
                case "disband":
                    break;
                case "who":
                    if (args.length == 1) {
                        Faction faction = fp.getFaction();
                        if (faction == null) {
                            fp.sendCenterMessage(new String[]{
                                    "&b---------&l" + fp.getName() + "&3---------",
                                    "&bName: &7" + fp.getName(),
                                    "&bKills: &7" + fp.getKills(),
                                    "&bDeaths: &7" + fp.getDeaths(),
                                    "&bLives: &7" + fp.getLives(),
                                    "&bFaction: &7none",
                                    "&b---------&l" + fp.getName() + "&b---------"
                            });
                            break;
                        }
                        List<String> memberList = new ArrayList<>();
                        faction.getMembers().forEach(fruitPlayer -> memberList.add(fruitPlayer.getName()));
                        String memberString = "";
                        if (!memberList.isEmpty()) {
                            for (String s : memberList) {
                                memberString += s + ",";
                            }
                        } else {
                            memberString = "none";
                        }
                        String dtrColor = (faction.getDtr() <= 0) ? "&c" : "&a";
                        fp.sendCenterMessage(new String[]{
                                "&3---------&l" + faction.getName() + "&3---------",
                                "&3Name: &7" + faction.getName(),
                                "&3DTR: " + (dtrColor + faction.getDtr()) + "",
                                "&3Home: &7" + faction.getParsedHome() + "",
                                "&3Leader: &7" + faction.getLeader().getName(),
                                "&3Members: &7" + memberString + "",
                                "&3---------&l" + faction.getName() + "&3---------"
                        });
                        break;
                    }
                    if (Bukkit.getPlayer(args[1]) != null) {
                        FruitPlayer target = GameAPI.getFruitPlayer(args[1]);
                        String name = (target.getFaction().getName() == null) ? "none" : target.getFaction().getName();
                        fp.sendCenterMessage(new String[]{
                                "&b---------&l" + target.getName() + "&3---------",
                                "&bName: &7" + target.getName(),
                                "&bKills: &7" + target.getKills(),
                                "&bDeaths: &7" + target.getDeaths(),
                                "&bLives: &7" + target.getLives(),
                                "&bFaction: &7" +name,
                                "&b---------&l" + target.getName() + "&b---------"
                        });
                        break;
                    } else if (FactionManager.getInstance().isFaction(args[1])) {
                        try {
                            Faction faction = FactionManager.getInstance().getFaction(args[1]);
                            List<String> memberList = new ArrayList<>();
                            faction.getMembers().forEach(fruitPlayer -> memberList.add(fruitPlayer.getName()));
                            String memberString = "";
                            if (!memberList.isEmpty()) {
                                for (String s : memberList) {
                                    memberString += s + ",";
                                }
                            } else {
                                memberString = "none";
                            }
                            String dtrColor = (faction.getDtr() <= 0) ? "&c" : "&a";
                            fp.sendCenterMessage(new String[]{
                                    "&3---------&l" + faction.getName() + "&3---------",
                                    "&3Name: &7" + faction.getName(),
                                    "&3DTR: " + (dtrColor + faction.getDtr()) + "",
                                    "&3Home: &7" + faction.getParsedHome() + "",
                                    "&3Leader: &7" + faction.getLeader().getName(),
                                    "&3Members: &7" + memberString + "",
                                    "&3---------&l" + faction.getName() + "&3---------"
                            });
                            break;
                        } catch (FactionNotFoundException e) {
                            fp.msg("&cCould not find faction!");
                            break;
                        }
                    }
                    break;
            }
        }
    }
}