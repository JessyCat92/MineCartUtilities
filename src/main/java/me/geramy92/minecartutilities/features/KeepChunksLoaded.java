package me.geramy92.minecartutilities.features;

import me.geramy92.minecartutilities.utilities.Logger;
import me.geramy92.minecartutilities.utilities.MineCartHelper;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

import java.util.ArrayList;

public class KeepChunksLoaded implements Listener {
    private ArrayList<Chunk> loadedChunks = new ArrayList<>();

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {
        if (!loadedChunks.contains(event.getChunk())) {
            loadedChunks.add(event.getChunk());
        }
    }

    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent event) {
        Entity[] entities = event.getChunk().getEntities();
        for (Entity entity : entities) {
            if (MineCartHelper.isEntityAMineCart(entity) && entity.getVelocity().length() > 0) {
                event.setCancelled(true);
                Logger.debugOnDebug("Keep Chunk loaded for Minecart.");
                break;
            } else {
                if (loadedChunks.contains(event.getChunk())) {
                    loadedChunks.remove(event.getChunk());
                }
            }
        }
    }

    @EventHandler
    public void onVehicleMove(VehicleMoveEvent event) {
        Location to = event.getTo();

        // to be sure we load all chunks in range
        int range = 5;
        for (int dx = -(range); dx <= range; dx++) {
            for (int dz = -(range); dz <= range; dz++) {
                Location location = new Location(to.getWorld(), to.getBlockX() + dx, to.getBlockY(), to.getBlockZ() + dz);

                if (!loadedChunks.contains(location.getChunk())) {
                    to.getWorld().loadChunk(location.getChunk());
                    Logger.debugOnDebug("Loaded new Chunk for Minecart.");
                }
            }
        }
    }
}
