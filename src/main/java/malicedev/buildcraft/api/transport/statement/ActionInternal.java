package malicedev.buildcraft.api.transport.statement;

public interface ActionInternal extends Statement {
    void actionActivate(StatementContainer source, StatementParameter[] parameters);
}
