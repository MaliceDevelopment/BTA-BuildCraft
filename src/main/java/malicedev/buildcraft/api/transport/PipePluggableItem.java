package malicedev.buildcraft.api.transport;

import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.pluggable.PipePluggable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
//import net.minecraft.core.util.helper.Direction;

public interface PipePluggableItem {
    PipePluggable createPipePluggable(PipeBlockEntity pipe, Direction side, ItemStack stack);
}
