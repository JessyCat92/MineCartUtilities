package me.geramy92.minecartutilities;

import me.geramy92.minecartutilities.utilities.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class MineCartUtilities extends JavaPlugin {
    private static MineCartUtilities mineCartUtilitiesInstance;

    @Override
    public void onEnable() {
        MineCartUtilities.mineCartUtilitiesInstance = this;

        Logger.success("Started MineCartUtilities successfully");
    }

    public static MineCartUtilities getInstance() {
        return mineCartUtilitiesInstance;
    }
}
