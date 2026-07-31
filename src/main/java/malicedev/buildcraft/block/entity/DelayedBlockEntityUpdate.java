package malicedev.buildcraft.block.entity;

import net.minecraft.entity.player.ServerPlayerEntity;

public interface DelayedBlockEntityUpdate {
    void onBlockEntityUpdatePacket(ServerPlayer player);
}
