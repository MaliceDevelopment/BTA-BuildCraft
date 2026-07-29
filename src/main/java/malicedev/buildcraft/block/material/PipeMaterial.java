package malicedev.buildcraft.block.material;

import net.minecraft.block.MapColor;
import net.minecraft.core.block.material.Material;

public class PipeMaterial extends Material {
    public PipeMaterial(MapColor mapColor) {
        super(mapColor);
        setDestroyPistonBehavior();
    }
}
