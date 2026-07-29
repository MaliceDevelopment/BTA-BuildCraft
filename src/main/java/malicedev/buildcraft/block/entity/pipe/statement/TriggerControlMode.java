package malicedev.buildcraft.block.entity.pipe.statement;

import malicedev.buildcraft.api.blockentity.ControlMode;
import malicedev.buildcraft.api.blockentity.Controllable;
import malicedev.buildcraft.api.transport.statement.StatementContainer;
import malicedev.buildcraft.api.transport.statement.StatementParameter;
import malicedev.buildcraft.api.transport.statement.TriggerExternal;
import net.minecraft.block.entity.BlockEntity;
import net.modificationstation.stationapi.api.util.math.Direction;
// TODO: finish implementing
public class TriggerControlMode extends BCStatement implements TriggerExternal {


    @Override
    public boolean isTriggerActive(BlockEntity target, Direction side, StatementContainer source, StatementParameter[] parameters) {
        if(target instanceof Controllable controllable){
            return controllable.getControlMode() == ControlMode.ON;
        }

        return false;
    }

    @Override
    public StatementParameter createParameter(int index) {
        return super.createParameter(index);
    }

    @Override
    public int maxParameters() {
        return 1;
    }
}
