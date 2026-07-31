package malicedev.buildcraft.inventory.slot;

import malicedev.buildcraft.screen.handler.BlueprintLibraryScreenHandler;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.slot.Slot;

public class BlueprintLibraryOutputSlot extends Slot {
    BlueprintLibraryScreenHandler handler;

    public BlueprintLibraryOutputSlot(BlueprintLibraryScreenHandler handler, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.handler = handler;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    @Override
    public void onTakeItem(ItemStack stack) {
        handler.onBlueprintUpdate();
        super.onTakeItem(stack);
    }

    @Override
    public void setStack(ItemStack stack) {
        handler.onBlueprintUpdate();
        super.setStack(stack);
    }

    @Override
    public ItemStack takeStack(int amount) {
        handler.onBlueprintUpdate();
        return super.takeStack(amount);
    }
}
