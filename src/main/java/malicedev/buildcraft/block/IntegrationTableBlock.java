package malicedev.buildcraft.block;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.block.entity.IntegrationTableBlockEntity;
import malicedev.buildcraft.screen.handler.IntegrationTableScreenHandler;
import malicedev.nyalib.block.DropInventoryOnBreak;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.gui.screen.container.GuiHelper;
import net.modificationstation.stationapi.api.util.Identifier;

public class IntegrationTableBlock extends TemplateMachineBlock implements DropInventoryOnBreak {
    public IntegrationTableBlock(Identifier identifier, Material material) {
        super(identifier, material);
        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new IntegrationTableBlockEntity();
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, Player player) {
        if (!world.isRemote) {
            if (world.getBlockEntity(x, y, z) instanceof IntegrationTableBlockEntity table) {
                GuiHelper.openGUI(player, Buildcraft.NAMESPACE.id("integration_table"), table, new IntegrationTableScreenHandler(player, table));
                return true;
            }
        }

        return super.onUse(world, x, y, z, player);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}
