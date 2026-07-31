package malicedev.buildcraft.block;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.block.entity.StirlingEngineBlockEntity;
import malicedev.buildcraft.screen.handler.StirlingEngineScreenHandler;
import malicedev.nyalib.block.DropInventoryOnBreak;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.gui.screen.container.GuiHelper;
import net.modificationstation.stationapi.api.util.Identifier;

public class StirlingEngineBlock extends BaseEngineBlock implements DropInventoryOnBreak {
    public StirlingEngineBlock(Identifier identifier) {
        super(identifier);
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new StirlingEngineBlockEntity();
    }

    @Override
    public String getBaseTexturePath() {
        return "/assets/buildcraft/stationapi/textures/block/engine_base_stirling.png";
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, Player player) {
        if (world.getBlockEntity(x, y, z) instanceof StirlingEngineBlockEntity engine) {
            GuiHelper.openGUI(player, Buildcraft.NAMESPACE.id("stirling_engine"), engine, new StirlingEngineScreenHandler(player, engine), (messagePacket -> {
                messagePacket.ints = new int[]{messagePacket.ints != null ? messagePacket.ints[0] : 0, x, y, z};
            }));
            return true;
        }

        return false;
    }
}
