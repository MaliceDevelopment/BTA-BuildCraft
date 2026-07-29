package malicedev.buildcraft.block.entity.pipe.statement;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.api.blockentity.ControlMode;
import malicedev.buildcraft.api.transport.statement.Statement;
import malicedev.buildcraft.api.transport.statement.StatementContainer;
import malicedev.buildcraft.api.transport.statement.StatementMouseClick;
import malicedev.buildcraft.api.transport.statement.StatementParameter;
import malicedev.buildcraft.registry.ControlModeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlas;
import net.modificationstation.stationapi.api.util.Identifier;

// TODO: finish implementing
public class StatementParameterControlMode implements StatementParameter {
    private ControlMode controlMode;

    @Override
    public Identifier getIdentifier() {
        return Buildcraft.NAMESPACE.id("control_mode");
    }

    @Environment(EnvType.CLIENT)
    @Override
    public Atlas.Sprite getSprite() {
        return controlMode.sprite;
    }

    @Override
    public ItemStack getItemStack() {
        return null;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void registerTextures() {

    }

    @Override
    public String getDescription() {
//        return controlMode.
        return "";
    }

    @Override
    public void click(StatementContainer source, Statement stmt, ItemStack stack, StatementMouseClick mouse) {

    }

    @Override
    public void readNBT(NbtCompound nbt) {
        if(nbt.contains("mode")){
            controlMode = ControlModeRegistry.get(Identifier.tryParse(nbt.getString("mode")));
        }
    }

    @Override
    public void writeNBT(NbtCompound nbt) {
        if(controlMode != null){
            nbt.putString("mode", controlMode.identifier.toString());
        }
    }

    @Override
    public StatementParameter rotateLeft() {
        return this;
    }
}
