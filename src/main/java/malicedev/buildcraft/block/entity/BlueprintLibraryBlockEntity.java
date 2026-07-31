package malicedev.buildcraft.block.entity;

import malicedev.buildcraft.inventory.SimpleInventory;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.item.ItemStack;

public class BlueprintLibraryBlockEntity extends BlockEntity implements Inventory {
    SimpleInventory inventory = new SimpleInventory(4, "Blueprint Library", this::markDirty);

    public BlueprintLibraryBlockEntity() {
    }

    @Override
    public int size() {
        return inventory.size();
    }

    @Override
    public ItemStack getStack(int slot) {
        return inventory.getStack(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return inventory.removeStack(slot, amount);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        inventory.setStack(slot, stack);
    }

    @Override
    public String getName() {
        return inventory.getName();
    }

    @Override
    public int getMaxCountPerStack() {
        return inventory.getMaxCountPerStack();
    }

    @Override
    public boolean canPlayerUse(Player player) {
        return inventory.canPlayerUse(player);
    }
}
