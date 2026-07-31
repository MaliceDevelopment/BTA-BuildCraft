package malicedev.buildcraft.block;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

public interface IWrenchable {
	boolean wrenchRightClick(ItemStack stack, Player player, boolean isSneaking, World world, @NotNull TilePosc tilePosc, int side);

}
