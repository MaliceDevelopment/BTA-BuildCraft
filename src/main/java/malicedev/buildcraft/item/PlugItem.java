package malicedev.buildcraft.item;

import malicedev.buildcraft.api.transport.PipePluggableItem;
import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.pluggable.PipePluggable;
import malicedev.buildcraft.block.entity.pipe.pluggable.PlugPluggable;
import net.minecraft.core.item.ItemStack;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;
import net.minecraft.core.util.helper.Direction;

public class PlugItem extends TemplateItem implements PipePluggableItem {
    public PlugItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public PipePluggable createPipePluggable(PipeBlockEntity pipe, Direction side, ItemStack stack) {
        return new PlugPluggable();
    }
}
