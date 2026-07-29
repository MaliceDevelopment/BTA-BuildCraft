package malicedev.buildcraft.init;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.api.blockentity.ControlMode;
import malicedev.buildcraft.event.ControlModeRegisterEvent;
import net.mine_diver.unsafeevents.listener.EventListener;

public class ControlModeListener {
    @EventListener
    public void registerControlModes(ControlModeRegisterEvent event) {
        event.register(ControlMode.ON = new ControlMode(Buildcraft.NAMESPACE.id("on"), null));
        event.register(ControlMode.OFF = new ControlMode(Buildcraft.NAMESPACE.id("off"), null));
    }
}
