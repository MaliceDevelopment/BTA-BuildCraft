package malicedev.buildcraft.block;

import malicedev.buildcraft.block.entity.FloodGateBlockEntity;
import malicedev.uniwrench.api.WrenchMode;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;
import net.minecraft.core.util.helper.Direction;

public class FloodGateBlock extends TemplateMachineBlock {
    public FloodGateBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new FloodGateBlockEntity();
    }

    @Override
    public boolean wrenchRightClick(ItemStack stack, Player player, boolean isSneaking, World world, int x, int y, int z, int side, WrenchMode wrenchMode) {
        if (wrenchMode == WrenchMode.MODE_WRENCH) {
            if (isSneaking) {
                return super.wrenchRightClick(stack, player, isSneaking, world, x, y, z, side, wrenchMode);
            }

            if (world.getBlockEntity(x, y, z) instanceof FloodGateBlockEntity blockEntity) {
                if (side == 1) {
                    blockEntity.rebuildQueue();
                } else {
                    blockEntity.switchSide(Direction.byId(side));
                }
                return true;
            }
        }

        return super.wrenchRightClick(stack, player, isSneaking, world, x, y, z, side, wrenchMode);
    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        if (world.getBlockEntity(x, y, z) instanceof FloodGateBlockEntity blockEntity) {
            blockEntity.neighborUpdate();
        }
    }
}
