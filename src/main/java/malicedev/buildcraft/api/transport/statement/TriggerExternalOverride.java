package malicedev.buildcraft.api.transport.statement;

import net.minecraft.core.util.helper.Direction;

public interface TriggerExternalOverride {
    enum Result {
        TRUE, FALSE, IGNORE
    }

    Result override(Direction side, StatementContainer source, StatementParameter[] parameters);
}
