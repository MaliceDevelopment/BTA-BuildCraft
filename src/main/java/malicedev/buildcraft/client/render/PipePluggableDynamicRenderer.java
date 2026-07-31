package malicedev.buildcraft.client.render;

import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.pluggable.PipePluggable;
import net.minecraft.core.util.helper.Direction;

public interface PipePluggableDynamicRenderer {
    void renderPluggable(PipeBlockEntity pipe, Direction side, PipePluggable pluggable, double x, double y, double z);
}
