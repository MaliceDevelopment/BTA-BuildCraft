package malicedev.buildcraft.api.transport.statement;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.core.util.helper.Direction;

public interface TriggerExternal extends Statement {
    boolean isTriggerActive(BlockEntity target, Direction side, StatementContainer source, StatementParameter[] parameters);
}
