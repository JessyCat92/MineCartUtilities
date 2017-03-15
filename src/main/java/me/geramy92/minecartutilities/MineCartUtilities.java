package me.geramy92.minecartutilities;

import me.geramy92.minecartutilities.utilities.Logger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class MineCartUtilities extends JavaPlugin {
    private static MineCartUtilities mineCartUtilitiesInstance;

    @Override
    public void onEnable() {
        MineCartUtilities.mineCartUtilitiesInstance = this;
        this.loadConfiguration();
        Logger.success("Started MineCartUtilities successfully");
    }

    /**
     *  Load Configuration or Create Configuration if it does not exist
     */
    private void loadConfiguration() {
        File configFile = new File(MineCartUtilities.getInstance().getDataFolder() + File.separator + "config.yml");
        if (!configFile.exists()) {
            MineCartUtilities.getInstance().saveResource("config.yml", true);
        }

        try {
            getConfig().load(configFile);
        } catch (InvalidConfigurationException | IOException e) {
            Logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static MineCartUtilities getInstance() {
        return mineCartUtilitiesInstance;
    }
}
