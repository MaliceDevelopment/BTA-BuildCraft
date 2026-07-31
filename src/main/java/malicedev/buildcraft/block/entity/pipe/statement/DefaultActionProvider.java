package malicedev.buildcraft.block.entity.pipe.statement;

import malicedev.buildcraft.api.transport.statement.ActionExternal;
import malicedev.buildcraft.api.transport.statement.ActionInternal;
import malicedev.buildcraft.api.transport.statement.ActionProvider;
import malicedev.buildcraft.api.transport.statement.StatementContainer;
import malicedev.buildcraft.api.transport.statement.container.RedstoneStatementContainer;
import malicedev.buildcraft.init.StatementListener;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.core.util.helper.Direction;

import java.util.Collection;
import java.util.LinkedList;

public class DefaultActionProvider implements ActionProvider {
    @Override
    public Collection<ActionInternal> getInternalActions(StatementContainer container) {
        LinkedList<ActionInternal> res = new LinkedList<>();

        if (container instanceof RedstoneStatementContainer) {
            res.add(StatementListener.actionRedstone);
        }

        return res;
    }

    @Override
    public Collection<ActionExternal> getExternalActions(Direction side, BlockEntity blockEntity) {
        @SuppressWarnings("UnnecessaryLocalVariable")
        LinkedList<ActionExternal> res = new LinkedList<>();

//        try {
//            if (tile instanceof IControllable) {
//                for (IControllable.Mode mode : IControllable.Mode.values()) {
//                    if (mode != IControllable.Mode.Unknown &&
//                                ((IControllable) tile).acceptsControlMode(mode)) {
//                        res.add(BuildCraftCore.actionControl[mode.ordinal()]);
//                    }
//                }
//            }
//        } catch (Throwable error) {
//            BCLog.logger.error("Outdated API detected, please update your mods!");
//        }

        return res;
    }
}
