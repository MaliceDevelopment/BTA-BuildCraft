package malicedev.buildcraft.screen.handler;

import malicedev.buildcraft.block.entity.AutocraftingTableBlockEntity;
import malicedev.buildcraft.inventory.AutocraftingTableInventory;
import malicedev.buildcraft.inventory.slot.AutocraftingTableResultSlot;
import net.minecraft.core.entity.player.Player;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.item.ItemStack;
import net.minecraft.recipe.CraftingRecipeManager;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.core.player.inventory.slot.Slot;

public class AutocraftingTableScreenHandler extends ScreenHandler {
    public Player player;
    public Inventory playerInventory;
    public AutocraftingTableBlockEntity blockEntity;

    public CraftingInventory craftingMatrix;
    public Inventory craftingResult;
    public Slot craftingResultSlot;

    public AutocraftingTableScreenHandler(Player player, AutocraftingTableBlockEntity blockEntity) {
        this.player = player;
        this.playerInventory = player.inventory;
        this.blockEntity = blockEntity;
        this.craftingMatrix = new AutocraftingTableInventory(this, blockEntity);
        this.craftingResult = new CraftingResultInventory();

        this.craftingResultSlot = new AutocraftingTableResultSlot(player, craftingMatrix, blockEntity, 10, 124, 35);
        this.addSlot(this.craftingResultSlot);

        // Crafting Slots
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                this.addSlot(new Slot(this.craftingMatrix, column + row * 3, 30 + column * 18, 17 + row * 18));
            }
        }

        // Player Inventory
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(playerInventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        // Hotbar Slots
        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(playerInventory, column, 8 + column * 18, 142));
        }

        updateCraftingResult();
    }

    @Override
    public void onSlotUpdate(Inventory inventory) {
        updateCraftingResult();
        super.onSlotUpdate(inventory);
    }

    public void updateCraftingResult() {
        craftingResultSlot.setStack(CraftingRecipeManager.getInstance().craft(this.craftingMatrix));
    }

    @Override
    public void setStackInSlot(int index, ItemStack stack) {
        super.setStackInSlot(index, stack);
    }

    @Override
    public boolean canUse(Player player) {
        return true;
    }
}
