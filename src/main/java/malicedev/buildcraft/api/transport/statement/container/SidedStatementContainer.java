package malicedev.buildcraft.api.transport.statement.container;

import malicedev.buildcraft.api.transport.statement.StatementContainer;
import net.minecraft.core.util.helper.Direction;

/**
 * Created by asie on 3/14/15.
 */
public interface SidedStatementContainer extends StatementContainer {
    Direction getSide();
}
