package malicedev.buildcraft.item;

import malicedev.buildcraft.api.core.Debuggable;
import malicedev.uniwrench.api.WrenchMode;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class 	BuildcraftWrenchItem {
    public BuildcraftWrenchItem(Identifier identifier) {
        super(identifier);
        addWrenchMode(WrenchMode.MODE_WRENCH);
        addWrenchMode(WrenchMode.MODE_ROTATE);
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            addWrenchMode(WrenchMode.MODE_DEBUG);
        }
    }

    @Override
    public boolean wrenchRightClick(ItemStack stack, Player player, boolean isSneaking, World world, int x, int y, int z, int side, WrenchMode wrenchMode) {
        if (wrenchMode == WrenchMode.MODE_DEBUG && world.getBlockState(x,y,z).getBlock() instanceof Debuggable debuggable) {
            debuggable.debug(stack, player, isSneaking, world, x, y, z, side);
            return true;
        }

        return super.wrenchRightClick(stack, player, isSneaking, world, x, y, z, side, wrenchMode);
    }
}
