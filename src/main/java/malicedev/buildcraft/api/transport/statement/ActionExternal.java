package malicedev.buildcraft.api.transport.statement;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.core.util.helper.Direction;

public interface ActionExternal extends Statement {
    void actionActivate(BlockEntity target, Direction side, StatementContainer source, StatementParameter[] parameters);
}
