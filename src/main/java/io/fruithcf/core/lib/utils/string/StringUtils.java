package io.fruithcf.core.lib.utils.string;

import org.bukkit.ChatColor;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 10:04 AM.
 */
public class StringUtils {

    /**
     * @apiNote this method parses string parsed as colored string
     * @author matt11matthew
     * @since 1.0
     * @version 1.0
     */
    public static String colorCodes(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
