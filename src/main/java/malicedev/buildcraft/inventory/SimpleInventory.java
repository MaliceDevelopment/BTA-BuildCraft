package malicedev.buildcraft.inventory;

import com.mojang.nbt.tags.CompoundTag;
import com.mojang.nbt.tags.ListTag;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.InventorySorter;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.item.ItemStack;


public class SimpleInventory implements Container {
    public ItemStack[] stacks;
    private final String name;
    private final MarkDirtyCallback markDirtyCallback;

    public SimpleInventory(int size, String name, MarkDirtyCallback markDirtyCallback) {
        this.stacks = new ItemStack[size];
        this.name = name;
        this.markDirtyCallback = markDirtyCallback;
    }

    @Override
    public int getContainerSize() {
        return stacks.length;
    }

    @Override
    public ItemStack getItem(int slot) {
        if (slot < 0 || slot >= stacks.length) {
            return null;
        }

        return stacks[slot];
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        if (slot < 0 || slot >= stacks.length) {
            return null;
        }

        if (this.stacks[slot] != null) {
            ItemStack stack;

            if (this.stacks[slot].stackSize <= amount) {
                stack = this.stacks[slot];
                this.stacks[slot] = null;
            } else {
                stack = this.stacks[slot].splitStack(amount);
                if (this.stacks[slot].stackSize == 0) {
                    this.stacks[slot] = null;
                }

            }

            this.setChanged();
            return stack;
        }

        return null;
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        if (slot < 0 || slot >= stacks.length) {
            return;
        }

        this.stacks[slot] = stack;
        if (stack != null && stack.stackSize > this.getMaxStackSize()) {
            stack.stackSize = this.getMaxStackSize();
        }
        this.setChanged();
    }

    @Override
    public String getNameTranslationKey() {
        return this.name;
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public void setChanged() {
        this.markDirtyCallback.markDirty();
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

	@Override
	public void sort() {
		InventorySorter.sortInventory(this.stacks);
	}

	@Override
	public boolean locked(int slot) {
		return Container.super.locked(slot);
	}


	public interface MarkDirtyCallback {
        void markDirty();
    }

    // NBT
    public void readNbt(CompoundTag nbt) {
        ListTag items = nbt.getList("Items");
        this.stacks = new ItemStack[this.getContainerSize()];

        for (int index = 0; index < items.tagCount(); ++index) {
            CompoundTag itemNbt = (CompoundTag) items.tagAt(index);
            int var5 = itemNbt.getByte("Slot") & 255;
            if (var5 < this.stacks.length) {
                this.stacks[var5] = ItemStack.readItemStackFromNbt(itemNbt);
            }
        }

    }

    public void writeNbt(CompoundTag nbt) {
        ListTag items = new ListTag();

        for (int index = 0; index < this.stacks.length; ++index) {
            if (this.stacks[index] != null) {
				CompoundTag itemNbt = new CompoundTag();
                itemNbt.putByte("Slot", (byte) index);
                this.stacks[index].writeToNBT(itemNbt);
                items.addTag(itemNbt);
            }
        }

        nbt.put("Items", items);
    }
}
