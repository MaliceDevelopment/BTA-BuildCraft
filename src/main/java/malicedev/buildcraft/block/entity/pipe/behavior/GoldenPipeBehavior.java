package malicedev.buildcraft.block.entity.pipe.behavior;

import malicedev.buildcraft.entity.TravellingItemEntity;
import malicedev.buildcraft.util.MathUtil;

public class GoldenPipeBehavior extends PipeBehavior {
    @Override
    public double modifyItemSpeed(TravellingItemEntity item) {
        return MathUtil.clamp(item.speed * 4D, TravellingItemEntity.DEFAULT_SPEED * 4D, TravellingItemEntity.DEFAULT_SPEED * 15D);
    }
}

