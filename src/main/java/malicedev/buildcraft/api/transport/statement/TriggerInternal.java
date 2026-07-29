package malicedev.buildcraft.api.transport.statement;

public interface TriggerInternal extends Statement {
    boolean isTriggerActive(StatementContainer source, StatementParameter[] parameters);
}
