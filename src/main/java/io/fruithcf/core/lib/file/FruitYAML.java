package io.fruithcf.core.lib.file;

import io.fruithcf.core.Game;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Giovanni on 22-10-2016.
 * <p>
 * This file is part of the FruitHCF project.
 * Copyright (c) 2016 FruitHCF;www.vawke.io / development@vawke.io
 */
public class FruitYAML
{
    @Getter
    private FileConfiguration fileConfiguration;

    private File file;

    public FruitYAML(String name, boolean par1)
    {
        if (par1)
        {
            this.file = new File(Game.getInstance().getDataFolder() + File.separator + "handle", name);
            this.fileConfiguration = YamlConfiguration.loadConfiguration(this.file);
        } else
        {
            this.file = new File(Game.getInstance().getDataFolder(), name);
            this.fileConfiguration = YamlConfiguration.loadConfiguration(this.file);
        }
    }

    public void setDefaults(Map<String, Object> map)
    {
        this.fileConfiguration.options().copyDefaults(true);
        this.fileConfiguration.addDefaults(map);
    }

    public boolean exists()
    {
        return file.exists();
    }

    public void save()
    {
        try
        {
            this.fileConfiguration.save(this.file);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
