package malicedev.buildcraft.block.entity.pipe.statement;

import malicedev.buildcraft.api.transport.statement.ActionExternal;
import malicedev.buildcraft.api.transport.statement.ActionInternal;
import malicedev.buildcraft.api.transport.statement.ActionProvider;
import malicedev.buildcraft.api.transport.statement.StatementContainer;
import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.gate.Gate;
import net.minecraft.block.entity.BlockEntity;
import net.modificationstation.stationapi.api.util.math.Direction;

import java.util.Collection;
import java.util.LinkedList;

public class PipeActionProvider implements ActionProvider {
    @Override
    public Collection<ActionInternal> getInternalActions(StatementContainer container) {
        LinkedList<ActionInternal> result = new LinkedList<>();
        PipeBlockEntity pipe = null;
        if (container instanceof malicedev.buildcraft.api.transport.gate.Gate) {
            pipe = ((malicedev.buildcraft.api.transport.gate.Gate) container).getPipe();

            if (container instanceof Gate) {
                ((Gate) container).addActions(result);
            }

            result.addAll(pipe.behavior.getActions(pipe));
        }

        //noinspection IfStatementWithIdenticalBranches
        if (pipe == null) {
            return result;
        }

        return result;
    }

    @Override
    public Collection<ActionExternal> getExternalActions(Direction side, BlockEntity blockEntity) {
        return null;
    }
}
