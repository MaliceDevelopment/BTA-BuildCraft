package malicedev.buildcraft.api.transport;

import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.pluggable.PipePluggable;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.math.Direction;

public interface PipePluggableItem {
    PipePluggable createPipePluggable(PipeBlockEntity pipe, Direction side, ItemStack stack);
}
