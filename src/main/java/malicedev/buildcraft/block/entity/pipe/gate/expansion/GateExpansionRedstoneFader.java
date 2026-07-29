package malicedev.buildcraft.block.entity.pipe.gate.expansion;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.api.transport.gate.GateExpansion;
import malicedev.buildcraft.api.transport.gate.GateExpansionController;
import malicedev.buildcraft.api.transport.statement.ActionInternal;
import malicedev.buildcraft.api.transport.statement.TriggerInternal;
import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.init.StatementListener;
import net.minecraft.block.entity.BlockEntity;

import java.util.Arrays;
import java.util.List;

public class GateExpansionRedstoneFader extends GateExpansionBuildcraft implements GateExpansion {
    public static GateExpansionRedstoneFader INSTANCE = new GateExpansionRedstoneFader();

    private GateExpansionRedstoneFader() {
        super(Buildcraft.NAMESPACE.id("fader"));
    }

    @Override
    public GateExpansionController makeController(PipeBlockEntity pipe) {
        return new GateExpansionControllerRedstoneFader(pipe);
    }

    private class GateExpansionControllerRedstoneFader extends GateExpansionController {
        public GateExpansionControllerRedstoneFader(BlockEntity pipe) {
            super(GateExpansionRedstoneFader.this, pipe);
        }

        @Override
        public void addTriggers(List<TriggerInternal> list) {
            super.addTriggers(list);
            list.addAll(Arrays.asList(StatementListener.triggerRedstoneLevel));
        }

        @Override
        public void addActions(List<ActionInternal> list) {
            super.addActions(list);
            list.addAll(Arrays.asList(StatementListener.actionRedstoneLevel));
        }
    }
}
