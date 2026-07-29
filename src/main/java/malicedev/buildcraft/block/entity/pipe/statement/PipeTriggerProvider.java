package malicedev.buildcraft.block.entity.pipe.statement;

import malicedev.buildcraft.api.transport.statement.StatementContainer;
import malicedev.buildcraft.api.transport.statement.TriggerExternal;
import malicedev.buildcraft.api.transport.statement.TriggerInternal;
import malicedev.buildcraft.api.transport.statement.TriggerProvider;
import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.gate.Gate;
import net.minecraft.block.entity.BlockEntity;
import net.modificationstation.stationapi.api.util.math.Direction;

import java.util.Collection;
import java.util.LinkedList;

public class PipeTriggerProvider implements TriggerProvider {
    @Override
    public Collection<TriggerInternal> getInternalTriggers(StatementContainer container) {
        LinkedList<TriggerInternal> result = new LinkedList<>();
        PipeBlockEntity pipe = null;
        BlockEntity blockEntity = container.getBlockEntity();

        if (blockEntity instanceof PipeBlockEntity) {
            pipe = (PipeBlockEntity) blockEntity;
        }

        if (pipe == null) {
            return result;
        }

        if (container instanceof Gate) {
            ((Gate) container).addTriggers(result);
        }

        switch (pipe.transporter.getType()) {
            case ITEM:
                result.add(TriggerPipeContents.PipeContents.empty.trigger);
                result.add(TriggerPipeContents.PipeContents.containsItems.trigger);
                break;
            case FLUID:
                result.add(TriggerPipeContents.PipeContents.empty.trigger);
                result.add(TriggerPipeContents.PipeContents.containsFluids.trigger);
                break;
            case ENERGY:
                result.add(TriggerPipeContents.PipeContents.empty.trigger);
                result.add(TriggerPipeContents.PipeContents.containsEnergy.trigger);
                result.add(TriggerPipeContents.PipeContents.tooMuchEnergy.trigger);
                result.add(TriggerPipeContents.PipeContents.requestsEnergy.trigger);
                break;
            case STRUCTURE:
                break;
        }
        return result;
    }

    @Override
    public Collection<TriggerExternal> getExternalTriggers(Direction side, BlockEntity blockEntity) {
        return new LinkedList<>();
    }
}
