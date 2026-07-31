package malicedev.buildcraft.inventory.slot;

import malicedev.buildcraft.block.entity.AutocraftingTableBlockEntity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.item.ItemStack;
import net.minecraft.screen.slot.CraftingResultSlot;

public class AutocraftingTableResultSlot extends CraftingResultSlot {
    public AutocraftingTableBlockEntity blockEntity;
    public Player player;

    public AutocraftingTableResultSlot(Player player, Inventory input, Inventory inventory, int index, int x, int y) {
        super(player, input, inventory, index, x, y);
        this.player = player;
        this.blockEntity = (AutocraftingTableBlockEntity) inventory;
    }

    @Override
    public void onTakeItem(ItemStack stack) {
        if (player != null) {
            stack.onCraft(this.player.world, this.player);

            player.inventory.setCursorStack(blockEntity.craft(false).copy());
        }
    }
}
