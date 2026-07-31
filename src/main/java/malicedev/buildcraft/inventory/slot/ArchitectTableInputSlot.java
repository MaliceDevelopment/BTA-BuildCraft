package malicedev.buildcraft.inventory.slot;

import malicedev.buildcraft.item.BuilderBlueprintItem;
import malicedev.buildcraft.item.BuilderTemplateItem;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.slot.Slot;

public class ArchitectTableInputSlot extends Slot {
    public ArchitectTableInputSlot(Container inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.getItem() instanceof BuilderTemplateItem || stack.getItem() instanceof BuilderBlueprintItem;
    }
}
