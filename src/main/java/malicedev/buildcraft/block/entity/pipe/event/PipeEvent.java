package malicedev.buildcraft.block.entity.pipe.event;

import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;

public abstract class PipeEvent {
    public final PipeBlockEntity pipe;

    public PipeEvent(PipeBlockEntity pipe){
        this.pipe = pipe;
    }
}
