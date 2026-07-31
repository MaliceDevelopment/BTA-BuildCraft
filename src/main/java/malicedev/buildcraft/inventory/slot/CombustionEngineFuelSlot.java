package malicedev.buildcraft.inventory.slot;

import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.item.BucketItem;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.slot.Slot;

public class CombustionEngineFuelSlot extends Slot {
    public CombustionEngineFuelSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if (stack == null) {
            return false;
        }

        return stack.getItem() instanceof BucketItem;
    }
}
