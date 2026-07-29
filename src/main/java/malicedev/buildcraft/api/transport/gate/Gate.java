package malicedev.buildcraft.api.transport.gate;

import malicedev.buildcraft.api.transport.statement.Statement;
import malicedev.buildcraft.api.transport.statement.StatementParameter;
import malicedev.buildcraft.api.transport.statement.StatementSlot;
import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;

import java.util.List;

public interface Gate {
    void setPulsing(boolean pulsing);

    PipeBlockEntity getPipe();

    List<Statement> getTriggers();

    List<Statement> getActions();

    List<StatementSlot> getActiveActions();

    List<StatementParameter> getTriggerParameters(int index);

    List<StatementParameter> getActionParameters(int index);
}
