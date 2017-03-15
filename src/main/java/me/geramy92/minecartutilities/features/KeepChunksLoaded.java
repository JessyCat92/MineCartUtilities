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
        Entity[] entities= event.getChunk().getEntities();
        for (Entity entity: entities) {
            if (MineCartHelper.isEntityAMineCart(entity) && entity.getVelocity().length() > 0) {
                event.setSaveChunk(true);
                event.setCancelled(true);
                Logger.debugOnDebug("Keep Chunk loaded for Minecart.");
                break;
            }
        }
    }

    @EventHandler
    public void onVehicleMove(VehicleMoveEvent event) {
        Location to = event.getTo();
        Chunk chunk = to.getChunk();

        if (!chunk.isLoaded()) {
            chunk.load();
            Logger.debugOnDebug("Loaded new Chunk for Minecart.");
        }
    }
}
