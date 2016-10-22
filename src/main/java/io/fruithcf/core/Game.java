package io.fruithcf.core;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Giovanni on 21-10-2016.
 * <p>
 * This file is part of the FruitHCF project.
 * Copyright (c) 2016 FruitHCF;www.vawke.io / development@vawke.io
 */
public class Game extends JavaPlugin
{
    @Getter
    private static Game instance;

    @Getter
    private HandlerCore handlerCore;

    @Override
    public void onEnable()
    {
        instance = this;

        this.handlerCore = new HandlerCore();
        this.handlerCore.prepare();
    }
}
