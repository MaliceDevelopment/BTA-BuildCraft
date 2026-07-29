package malicedev.buildcraft.api.transport.statement;

public interface ActionReceptor {
    void actionActivated(Statement statement, StatementParameter[] parameters);
}
