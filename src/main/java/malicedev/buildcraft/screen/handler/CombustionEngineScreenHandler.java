package malicedev.buildcraft.screen.handler;

import malicedev.buildcraft.block.entity.CombustionEngineBlockEntity;
import malicedev.buildcraft.inventory.slot.CombustionEngineFuelSlot;
import malicedev.buildcraft.inventory.slot.InvisibleFluidSlot;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.core.player.inventory.slot.Slot;

@SuppressWarnings("FieldCanBeLocal")
public class CombustionEngineScreenHandler extends ScreenHandler {
    private final Player player;
    private final Inventory playerInventory;

    private final CombustionEngineBlockEntity engine;

    public CombustionEngineScreenHandler(Player player, CombustionEngineBlockEntity engine) {
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
                new CombustionEngineFuelSlot(
                        engine,
                        0,
                        52,
                        41
                )
        );

        this.addFluidSlot(
                new InvisibleFluidSlot(
                        engine,
                        0,
                        122,
                        19,
                        16,
                        59
                )
        );

        this.addFluidSlot(
                new InvisibleFluidSlot(
                        engine,
                        1,
                        104,
                        19,
                        16,
                        59
                )
        );
    }

    @Override
    public boolean canUse(Player player) {
        return true;
    }
}
