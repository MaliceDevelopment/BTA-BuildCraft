package malicedev.buildcraft.init;

import malicedev.buildcraft.block.entity.pipe.pluggable.FacadePluggable;
import malicedev.buildcraft.block.entity.pipe.pluggable.GatePluggable;
import malicedev.buildcraft.block.entity.pipe.pluggable.LensPluggable;
import malicedev.buildcraft.block.entity.pipe.pluggable.PlugPluggable;
import malicedev.buildcraft.registry.PluggableRegisterEvent;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;

public class PluggableListener {
    @Entrypoint.Namespace
    public static Namespace NAMESPACE;

    @EventListener
    public void registerPluggables(PluggableRegisterEvent event){
        event.register(NAMESPACE.id("plug"), PlugPluggable.class, PlugPluggable::new);
        event.register(NAMESPACE.id("facade"), FacadePluggable.class, FacadePluggable::new);
        event.register(NAMESPACE.id("gate"), GatePluggable.class, GatePluggable::new);
        event.register(NAMESPACE.id("lens"), LensPluggable.class, LensPluggable::new);
    }
}
