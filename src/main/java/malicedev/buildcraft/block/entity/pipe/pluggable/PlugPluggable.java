package malicedev.buildcraft.block.entity.pipe.pluggable;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.client.render.PipePluggableRenderer;
import malicedev.buildcraft.client.render.pluggable.PlugPluggableRenderer;
import malicedev.buildcraft.util.MatrixTransformation;
import net.minecraft.core.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.Box;
import net.minecraft.core.util.helper.Direction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@SuppressWarnings("RedundantThrows")
public class PlugPluggable extends PipePluggable {

    @Override
    public ItemStack[] getDropItems(PipeBlockEntity pipe) {
        return new ItemStack[]{new ItemStack(Buildcraft.plug)};
    }

    @Override
    public Box getBoundingBox(Direction side) {
        float[][] bounds = new float[3][2];
        // X START - END
        bounds[0][0] = 0.25F;
        bounds[0][1] = 0.75F;
        // Y START - END
        bounds[1][0] = 0.125F;
        bounds[1][1] = 0.251F;
        // Z START - END
        bounds[2][0] = 0.25F;
        bounds[2][1] = 0.75F;

        MatrixTransformation.transform(bounds, side);
        return Box.createCached(bounds[0][0], bounds[1][0], bounds[2][0], bounds[0][1], bounds[1][1], bounds[2][1]);
    }

    @Override
    public PipePluggableRenderer getRenderer() {
        return PlugPluggableRenderer.INSTANCE;
    }

    @Override
    public boolean isSolidOnSide() {
        return true;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
    }

    @Override
    public void writeData(DataOutputStream stream) throws IOException {

    }

    @Override
    public void readData(DataInputStream stream) throws IOException {

    }
}
