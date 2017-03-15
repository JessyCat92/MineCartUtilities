package me.geramy92.minecartutilities;

import me.geramy92.minecartutilities.utilities.Logger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MineCartUtilities extends JavaPlugin {
    private static MineCartUtilities mineCartUtilitiesInstance;

    @Override
    public void onEnable() {
        MineCartUtilities.mineCartUtilitiesInstance = this;

        // ensure config file
        File configFile = new File(MineCartUtilities.getInstance().getDataFolder() + File.separator + "config.yml");
        if (!configFile.exists()) {
            MineCartUtilities.getInstance().saveResource("config.yml", true);
        }

        try {
            getConfig().load(configFile);
        } catch (InvalidConfigurationException e) {
            Logger.error(e.getMessage());
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            Logger.error(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            Logger.error(e.getMessage());
            e.printStackTrace();
        }

        Logger.debug(getConfig().getString("keepChunksLoaded"));
        Logger.success("Started MineCartUtilities successfully");
    }

    public static MineCartUtilities getInstance() {
        return mineCartUtilitiesInstance;
    }
}
