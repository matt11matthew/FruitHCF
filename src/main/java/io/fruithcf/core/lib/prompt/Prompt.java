package io.fruithcf.core.lib.prompt;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 10:24 AM.
 */
public class Prompt {

    public static void sendCenteredMessage(Player player, String[] par1) {
        for (String s : par1) {
            if (s == null || s.equals("")) player.sendMessage("");
            s = ChatColor.translateAlternateColorCodes('&', s);

            int messagePxSize = 0;
            boolean previousCode = false;
            boolean isBold = false;

            for (char c : s.toCharArray()) {
                if (c == '§') {
                    previousCode = true;
                } else if (previousCode) {
                    previousCode = false;
                    isBold = c == 'l' || c == 'L';
                } else {
                    DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                    messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
                    messagePxSize++;
                }
            }

            int halvedMessageSize = messagePxSize / 2;
            int toCompensate = 154 - halvedMessageSize;
            int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
            int compensated = 0;
            StringBuilder sb = new StringBuilder();
            while (compensated < toCompensate) {
                sb.append(" ");
                compensated += spaceLength;
            }
            player.sendMessage(sb.toString() + s);
        }
    }

}
