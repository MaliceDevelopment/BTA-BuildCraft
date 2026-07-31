package malicedev.buildcraft.inventory.slot;

import malicedev.buildcraft.util.FuelUtil;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.slot.Slot;

public class StirlingEngineFuelSlot extends Slot {
    public StirlingEngineFuelSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return FuelUtil.getEngineFuelTime(stack) > 0;
    }
}
