package io.fruithcf.core.api.nms;

import io.fruithcf.core.lib.utils.string.StringUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 12:06 PM.
 */
public class NMSUtils {

    public static void sendActionMessage(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(StringUtils.colorCodes(message)));
    }
}
