package malicedev.buildcraft.inventory.slot;

import malicedev.buildcraft.item.BuilderBlueprintItem;
import malicedev.buildcraft.item.BuilderTemplateItem;
import malicedev.buildcraft.screen.handler.BlueprintLibraryScreenHandler;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.slot.Slot;

public class BlueprintLibraryInputSlot extends Slot {
    BlueprintLibraryScreenHandler handler;

    public BlueprintLibraryInputSlot(BlueprintLibraryScreenHandler handler, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.handler = handler;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() instanceof BuilderTemplateItem || stack.getItem() instanceof BuilderBlueprintItem;
    }

    @Override
    public void onTakeItem(ItemStack stack) {
        super.onTakeItem(stack);
        handler.onBlueprintUpdate();
    }

    @Override
    public void setStack(ItemStack stack) {
        super.setStack(stack);
        handler.onBlueprintUpdate();
    }

    @Override
    public void markDirty() {
        super.markDirty();
        handler.onBlueprintUpdate();
    }
}
