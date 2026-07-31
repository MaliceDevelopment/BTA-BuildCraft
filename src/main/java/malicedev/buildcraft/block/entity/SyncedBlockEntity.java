package malicedev.buildcraft.block.entity;

import malicedev.buildcraft.api.core.Serializable;
import malicedev.buildcraft.packet.BlockEntityUpdateS2CPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.packet.Packet;
import net.modificationstation.stationapi.api.network.packet.PacketHelper;

public abstract class SyncedBlockEntity extends BlockEntity implements Serializable, DelayedBlockEntityUpdate {
    public Packet getUpdatePacket(){
        return new BlockEntityUpdateS2CPacket(this);
    }

    public void sendNetworkUpdate(){
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER){
            if(world != null && !world.isRemote){
                Packet updatePacket = getUpdatePacket();
                for(Object o : world.players){
                    Player player = (PlayerEntity) o;
                    if(player.getDistance(x, y, z) < getNetworkUpdateRange()){
                        PacketHelper.sendTo(player, updatePacket);
                    }
                }
            }
        }
    }

    private int getNetworkUpdateRange(){
        return 64;
    }

    @Override
    public Packet createUpdatePacket() {
        return getUpdatePacket();
    }

    @Environment(EnvType.SERVER)
    @Override
    public void onBlockEntityUpdatePacket(ServerPlayer player) {
        PacketHelper.sendTo(player, getUpdatePacket());
    }
}
