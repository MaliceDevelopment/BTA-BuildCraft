package malicedev.buildcraft.block.entity.pipe.transporter;

import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.PipeTransporter;
import malicedev.buildcraft.block.entity.pipe.PipeType;

public class StructurePipeTransporter extends PipeTransporter {
    public StructurePipeTransporter(PipeBlockEntity blockEntity) {
        super(blockEntity);
    }

    @Override
    public PipeType getType() {
        return PipeType.STRUCTURE;
    }
}
