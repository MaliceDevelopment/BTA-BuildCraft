package malicedev.buildcraft.api.transport.statement;

import java.util.List;

public interface OverrideDefaultStatements {
    List<TriggerExternal> overrideTriggers();

    List<ActionExternal> overrideActions();
}
