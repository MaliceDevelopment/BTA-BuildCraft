package malicedev.buildcraft.client.render.pluggable;

import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.pluggable.PipePluggable;
import malicedev.buildcraft.client.render.PipePluggableDynamicRenderer;
import malicedev.buildcraft.client.render.PipePluggableRenderer;
import malicedev.buildcraft.client.render.block.entity.PipeBlockEntityRenderer;
import malicedev.buildcraft.block.entity.pipe.pluggable.GatePluggable;
import net.minecraft.client.render.block.BlockRenderManager;
import net.modificationstation.stationapi.api.util.math.Direction;

public class GatePluggableRenderer implements PipePluggableRenderer, PipePluggableDynamicRenderer {
    public static final GatePluggableRenderer INSTANCE = new GatePluggableRenderer();
    @Override
    public void renderPluggable(PipeBlockEntity pipe, Direction side, PipePluggable pluggable, double x, double y, double z) {
        PipeBlockEntityRenderer.renderGate(x, y, z, (GatePluggable) pluggable, side);
    }

    @Override
    public void renderPluggable(BlockRenderManager blockRenderManager, PipeBlockEntity pipe, Direction side, PipePluggable pluggable, int x, int y, int z) {
        PipeBlockEntityRenderer.renderGateStatic(blockRenderManager, side, (GatePluggable) pluggable, x, y, z);
    }
}
