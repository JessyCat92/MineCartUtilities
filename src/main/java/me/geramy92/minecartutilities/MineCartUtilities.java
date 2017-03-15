package me.geramy92.minecartutilities;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Geramy92 on 14.03.2017.
 */
public class MineCartUtilities extends JavaPlugin{
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("Started MineCartUtilities");
    }
}
