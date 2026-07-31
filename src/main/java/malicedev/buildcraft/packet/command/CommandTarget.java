package malicedev.buildcraft.packet.command;

import net.minecraft.core.entity.player.Player;
import net.minecraft.world.World;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public abstract class CommandTarget {
    public abstract Class<?> getHandledClass();
    public abstract CommandReceiver handle(Player player, DataInputStream data, World world);
    public abstract void write(DataOutputStream data, Object target);
}
