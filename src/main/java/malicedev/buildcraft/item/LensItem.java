package malicedev.buildcraft.item;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.api.transport.PipePluggableItem;
import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.PipeJsonOverride;
import malicedev.buildcraft.block.entity.pipe.pluggable.PipePluggable;
import malicedev.buildcraft.block.entity.pipe.PipeType;
import malicedev.buildcraft.block.entity.pipe.pluggable.LensPluggable;
import malicedev.buildcraft.util.ColorUtil;
import net.minecraft.core.item.ItemStack;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.minecraft.core.util.helper.Direction;

public class LensItem extends TemplateItem implements PipePluggableItem {
    public final int color;
    public final boolean isFilter;

    public LensItem(int color, boolean isFilter) {
        super(Buildcraft.NAMESPACE.id(ColorUtil.getName(color) + "_" + (isFilter ? "filter" : "lens")));
        this.color = color;
        this.isFilter = isFilter;
        PipeJsonOverride.registerLensJsonOverride(Buildcraft.NAMESPACE.id(ColorUtil.getName(color) + "_" + (isFilter ? "filter" : "lens")), Buildcraft.NAMESPACE.id("item/" + (isFilter ? "filter" : "lens")));
    }

    @Override
    public PipePluggable createPipePluggable(PipeBlockEntity pipe, Direction side, ItemStack stack) {
        if(pipe.transporter.getType() == PipeType.ITEM){
            return new LensPluggable(color, isFilter);
        } else {
            return null;
        }
    }
}
