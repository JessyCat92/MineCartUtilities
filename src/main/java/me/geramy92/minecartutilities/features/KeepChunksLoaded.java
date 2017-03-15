package me.geramy92.minecartutilities.features;

import me.geramy92.minecartutilities.utilities.Logger;
import me.geramy92.minecartutilities.utilities.MineCartHelper;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

public class KeepChunksLoaded implements Listener {

    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent event) {
        Entity[] entities = event.getChunk().getEntities();
        for (Entity entity : entities) {
            if (MineCartHelper.isEntityAMineCart(entity) && entity.getVelocity().length() > 0) {
                event.setCancelled(true);
                Logger.debugOnDebug("Keep Chunk loaded for Minecart.");
                break;
            }
        }
    }

    @EventHandler
    public void onVehicleMove(VehicleMoveEvent event) {
        Location to = event.getTo();

        // to be sure we load all chunks in range
        int range = 2;
        for (int dx = -(range); dx <= range; dx++) {
            for (int dz = -(range); dz <= range; dz++) {
                Chunk newChunk = to.getWorld().getChunkAt(to.getBlockX() + dx, to.getBlockZ() + dz);
                if (!to.getWorld().isChunkLoaded(newChunk)) {
                    to.getWorld().loadChunk(newChunk);
                    Logger.debugOnDebug("Loaded new Chunk for Minecart.");
                }
            }
        }
    }
}
