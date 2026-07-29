package malicedev.buildcraft.event;

import malicedev.buildcraft.api.blockentity.ControlMode;
import malicedev.buildcraft.registry.ControlModeRegistry;
import net.mine_diver.unsafeevents.Event;

public class ControlModeRegisterEvent extends Event {
    public ControlModeRegistry registry;

    public ControlModeRegisterEvent() {
        registry = ControlModeRegistry.getInstance();
    }

    public boolean register(ControlMode controlMode) {
        return ControlModeRegistry.register(controlMode);
    }
}
