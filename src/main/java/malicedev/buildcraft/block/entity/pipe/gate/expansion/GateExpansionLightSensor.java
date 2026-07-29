package malicedev.buildcraft.block.entity.pipe.gate.expansion;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.api.transport.gate.GateExpansion;
import malicedev.buildcraft.api.transport.gate.GateExpansionController;
import malicedev.buildcraft.api.transport.statement.TriggerInternal;
import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.init.StatementListener;
import net.minecraft.block.entity.BlockEntity;

import java.util.List;

public class GateExpansionLightSensor extends GateExpansionBuildcraft implements GateExpansion {

    public static GateExpansionLightSensor INSTANCE = new GateExpansionLightSensor();

    public GateExpansionLightSensor() {
        super(Buildcraft.NAMESPACE.id("light_sensor"));
    }

    @Override
    public GateExpansionController makeController(PipeBlockEntity pipe) {
        return new GateExpansionControllerLightSensor(pipe);
    }

    private class GateExpansionControllerLightSensor extends GateExpansionController {

        public GateExpansionControllerLightSensor(BlockEntity pipe) {
            super(GateExpansionLightSensor.this, pipe);
        }

        @Override
        public void addTriggers(List<TriggerInternal> list) {
            super.addTriggers(list);
            list.add(StatementListener.triggerLightSensorBright);
            list.add(StatementListener.triggerLightSensorDark);
        }
    }
}
