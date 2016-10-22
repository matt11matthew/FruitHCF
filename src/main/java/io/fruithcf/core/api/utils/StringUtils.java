package io.fruithcf.core.api.utils;

import org.bukkit.ChatColor;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/21/2016 at 10:06 PM.
 */
public class StringUtils {

    private static StringUtils instance;

    public static StringUtils get() {
        if (instance == null) {
            instance = new StringUtils();
        }
        return instance;
    }

    public String colorCodes(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
