package malicedev.buildcraft.block.entity.pipe.event;

import com.google.common.collect.Multiset;
import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.nyalib.fluid.FluidStack;
import net.minecraft.core.util.helper.Direction;

public class FluidPipeEvent extends PipeEvent{
    public final FluidStack fluidStack;
    public FluidPipeEvent(PipeBlockEntity pipe, FluidStack fluidStack) {
        super(pipe);
        this.fluidStack = fluidStack;
    }

    public static class FindDest extends FluidPipeEvent {
        public final Multiset<Direction> destinations;

        public FindDest(PipeBlockEntity pipe, FluidStack fluidStack, Multiset<Direction> destinations) {
            super(pipe, fluidStack);
            this.destinations = destinations;
        }
    }
}
