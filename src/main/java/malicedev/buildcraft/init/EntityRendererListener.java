package malicedev.buildcraft.init;

import malicedev.buildcraft.client.render.entity.EntityBlockRenderer;
import malicedev.buildcraft.client.render.entity.RobotEntityRenderer;
import malicedev.buildcraft.client.render.entity.VoidEntityRenderer;
import malicedev.buildcraft.entity.EntityBlock;
import malicedev.buildcraft.entity.EntityBlockWithParent;
import malicedev.buildcraft.entity.MechanicalArmEntity;
import malicedev.buildcraft.entity.RobotEntity;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;

@SuppressWarnings("unused")
public class EntityRendererListener {
    @EventListener
    public void registerEntityRenderers(EntityRendererRegisterEvent event){
        event.renderers.put(EntityBlock.class, EntityBlockRenderer.INSTANCE);
        event.renderers.put(EntityBlockWithParent.class, EntityBlockRenderer.INSTANCE);
        event.renderers.put(RobotEntity.class, RobotEntityRenderer.INSTANCE);
        event.renderers.put(MechanicalArmEntity.class, VoidEntityRenderer.INSTANCE);
    }
}
