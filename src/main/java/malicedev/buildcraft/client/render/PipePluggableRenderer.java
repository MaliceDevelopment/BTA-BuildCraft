package malicedev.buildcraft.client.render;

import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.pluggable.PipePluggable;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.core.util.helper.Direction;

public interface PipePluggableRenderer {
    void renderPluggable(BlockRenderManager blockRenderManager, PipeBlockEntity pipe, Direction side, PipePluggable pluggable, int x, int y, int z);
}
