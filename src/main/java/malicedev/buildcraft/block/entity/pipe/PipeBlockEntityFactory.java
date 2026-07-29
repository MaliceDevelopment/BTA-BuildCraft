package malicedev.buildcraft.block.entity.pipe;

import malicedev.buildcraft.block.PipeBlock;

public interface PipeBlockEntityFactory {
    PipeBlockEntity create(PipeBlock block);
}
