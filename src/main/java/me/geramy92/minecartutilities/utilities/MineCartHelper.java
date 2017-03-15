package me.geramy92.minecartutilities.utilities;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.Arrays;

public class MineCartHelper {
    private static EntityType[] mineCartEntityTypes = new EntityType[]{
            EntityType.MINECART,
            EntityType.MINECART_CHEST,
            EntityType.MINECART_COMMAND,
            EntityType.MINECART_FURNACE,
            EntityType.MINECART_HOPPER,
            EntityType.MINECART_MOB_SPAWNER,
            EntityType.MINECART_TNT
    };

    private MineCartHelper(){}

    public static boolean isEntityAMineCart(Entity entity) {
        return Arrays.asList(MineCartHelper.mineCartEntityTypes).contains(entity.getType());
    }
}
