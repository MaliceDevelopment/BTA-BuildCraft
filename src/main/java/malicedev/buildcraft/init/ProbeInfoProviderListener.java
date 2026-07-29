package malicedev.buildcraft.init;

import malicedev.buildcraft.compat.whatshis.BuildcraftProbeInfoProvider;
import malicedev.whatsthis.event.BlockProbeInfoProviderRegistryEvent;
import net.mine_diver.unsafeevents.listener.EventListener;

public class ProbeInfoProviderListener {
    @EventListener
    public void registerBlockProbeInfoProviders(BlockProbeInfoProviderRegistryEvent event) {
        event.registerProvider(new BuildcraftProbeInfoProvider());
    }
}
