package malicedev.buildcraft.block.entity.pipe;

import malicedev.buildcraft.api.energy.IPowerReceptor;
import malicedev.buildcraft.api.energy.PowerHandler;
import malicedev.buildcraft.block.PipeBlock;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.math.Direction;

public class PoweredPipeBlockEntity extends PipeBlockEntity implements IPowerReceptor {
    protected PowerHandler powerHandler;

    public PoweredPipeBlockEntity(PipeBlock pipeBlock) {
        super(pipeBlock);
        configurePower();
    }

    public PoweredPipeBlockEntity() {
        super();
        configurePower();
    }

    @Override
    public void tick() {
        super.tick();
        powerHandler.update();
    }

    public void configurePower() {
        powerHandler = new PowerHandler(this, PowerHandler.Type.PIPE);
        powerHandler.configure(1.0D, 16D, 1.0D, 16D);
        powerHandler.configurePowerPerdition(0,0);
    }

    @Override
    public PowerHandler.PowerReceiver getPowerReceiver(Direction side) {
        return powerHandler.getPowerReceiver();
    }

    @Override
    public void doWork(PowerHandler workProvider) {
        behavior.doWork(this, workProvider);
    }

    @Override
    public World getWorld() {
        return world;
    }
}
