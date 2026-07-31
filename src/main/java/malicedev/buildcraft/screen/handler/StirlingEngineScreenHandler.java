package malicedev.buildcraft.screen.handler;

import malicedev.buildcraft.block.entity.StirlingEngineBlockEntity;
import malicedev.buildcraft.inventory.slot.StirlingEngineFuelSlot;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.core.player.inventory.slot.Slot;

@SuppressWarnings({"SwitchStatementWithTooFewBranches", "FieldCanBeLocal"})
public class StirlingEngineScreenHandler extends ScreenHandler {
    private final Player player;
    private final Inventory playerInventory;

    private final StirlingEngineBlockEntity engine;

    public int scaledBurnTime;

    public StirlingEngineScreenHandler(Player player, StirlingEngineBlockEntity engine) {
        this.player = player;
        this.playerInventory = player.inventory;
        this.engine = engine;

        int playerInventoryVerticalOffset = 168 / 2;
        int playerInventoryHorizontalOffset = 0;

        int row;
        int column;

        // Player Inventory
        for (row = 0; row < 3; row++) {
            for (column = 0; column < 9; column++) {
                this.addSlot(new Slot(playerInventory,
                                column + (row * 9) + 9,
                                playerInventoryHorizontalOffset + 8 + (column * 18),
                                playerInventoryVerticalOffset + (row * 18)
                        )
                );
            }
        }

        // Player Hotbar
        for (row = 0; row < 9; row++) {
            this.addSlot(new Slot(playerInventory,
                            row,
                            playerInventoryHorizontalOffset + 8 + (row * 18),
                            playerInventoryVerticalOffset + 58
                    )
            );
        }

        // The Generator Slot
        this.addSlot(
                new StirlingEngineFuelSlot(
                        engine,
                        0,
                        80,
                        41
                )
        );
    }

    @Environment(EnvType.SERVER)
    @Override
    public void addListener(ScreenHandlerListener listener) {
        super.addListener(listener);
        listener.onPropertyUpdate(this, 0, this.engine.getScaledBurnTime(12));
    }

    @Override
    public void sendContentUpdates() {
        super.sendContentUpdates();

        for (var listenerO : this.listeners) {
            if (listenerO instanceof ScreenHandlerListener listener) {
                if (this.scaledBurnTime != this.engine.getScaledBurnTime(12)) {
                    this.scaledBurnTime = this.engine.getScaledBurnTime(12);
                    listener.onPropertyUpdate(this, 0, this.scaledBurnTime);
                }
            }
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void setProperty(int id, int value) {
        switch (id) {
            case 0 -> {
                this.scaledBurnTime = value;
            }
        }
    }

    @Override
    public boolean canUse(Player player) {
        return true;
    }
}
