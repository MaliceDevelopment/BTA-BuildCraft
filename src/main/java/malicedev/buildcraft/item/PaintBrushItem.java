package malicedev.buildcraft.item;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.api.core.PaintableBlock;
import malicedev.buildcraft.util.ColorUtil;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;
import net.minecraft.core.util.helper.Direction;

public class PaintBrushItem extends TemplateItem {
    public final int color;

    public PaintBrushItem(Identifier identifier, int color) {
        super(identifier);
        this.color = color;

        setMaxCount(1);
        setMaxDamage(63);
    }

    public PaintBrushItem(int color) {
        this(Buildcraft.NAMESPACE.id(ColorUtil.getName(color) + "_paintbrush"), color);
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        BlockState blockState = world.getBlockState(x, y, z);

        if (blockState.getBlock() instanceof PaintableBlock paintableBlock) {
            if (color >= 0) {
                if (paintableBlock.recolorBlock(world, x, y, z, Direction.byId(side), color)) {
                    stack.setDamage(stack.getDamage() + 1);
                    if(stack.getDamage() > stack.getMaxDamage()){
                        user.increaseStat(Stats.BROKEN[this.id], 1);
                        stack.itemId = Buildcraft.paintbrush.id;
                        stack.setDamage(0);
                    }
                    return true;
                }
            } else {
                if (paintableBlock.canRemoveColor(world, x, y, z, Direction.byId(side))) {
                    return paintableBlock.removeColorFromBlock(world, x, y, z, Direction.byId(side));
                }
            }
        }
        return false;
    }
}
