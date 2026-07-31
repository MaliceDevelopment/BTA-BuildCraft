package malicedev.buildcraft.block.entity.pipe.behavior;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.transporter.ItemPipeTransporter;
import malicedev.buildcraft.block.entity.pipe.transporter.ItemPipeTransporter.HandOffResult;
import malicedev.buildcraft.entity.TravellingItemEntity;
import malicedev.nyalib.capability.CapabilityHelper;
import malicedev.nyalib.capability.block.itemhandler.ItemHandlerBlockCapability;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;

public class ClayPipeBehavior extends PipeBehavior {
    @Override
    public Direction routeItem(PipeBlockEntity blockEntity, ObjectArrayList<Direction> validOutputDirections, TravellingItemEntity item) {
        ObjectArrayList<Direction> directions = new ObjectArrayList<>(validOutputDirections);

        for (Direction side : directions) {
            var cap = CapabilityHelper.getCapability(blockEntity.world, blockEntity.x + side.getOffsetX(), blockEntity.y + side.getOffsetY(), blockEntity.z + side.getOffsetZ(), ItemHandlerBlockCapability.class);
            if (cap != null) {
                if (!cap.canInsertItem(side.getOpposite())) {
                    directions.remove(side);
                    continue;
                }

                boolean canInsert = false;
                for (ItemStack stack : cap.getInventory(side.getOpposite())) {
                    if (stack == null) {
                        canInsert = true;
                        break;
                    }

                    if (stack.isItemEqual(item.stack) && stack.count < stack.getMaxCount()) {
                        canInsert = true;
                        break;
                    }
                }

                if (!canInsert) {
                    directions.remove(side);
                }
            }
        }

        if (directions.size() > 1) {
            directions.remove(item.input);
        }

        if (directions.isEmpty()) {
            return null;
        }

        return directions.get(blockEntity.random.nextInt(directions.size()));
    }

    @Override
    public HandOffResult getFailedInsertResult(PipeBlockEntity blockEntity, ItemPipeTransporter transporter, TravellingItemEntity item) {
        return HandOffResult.BOUNCE;
    }
}
