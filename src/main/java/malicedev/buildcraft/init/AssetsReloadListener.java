package malicedev.buildcraft.init;

import malicedev.buildcraft.client.render.FluidRenderer;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.resource.AssetsReloadEvent;

public class AssetsReloadListener {
    @EventListener
    public void reloadAssets(AssetsReloadEvent event){
        FluidRenderer.onTextureReload();
    }
}
