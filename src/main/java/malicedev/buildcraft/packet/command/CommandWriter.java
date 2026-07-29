package malicedev.buildcraft.packet.command;

import java.io.DataOutputStream;

public abstract class CommandWriter {
    public abstract void write(DataOutputStream data);
}
