package malicedev.buildcraft.api.core;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public interface Debuggable {
    void debug(ItemStack stack, Player player, boolean isSneaking, World world, int x, int y, int z, int side);
}
