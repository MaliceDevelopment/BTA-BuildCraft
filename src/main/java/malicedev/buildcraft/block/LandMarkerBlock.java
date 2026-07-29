package malicedev.buildcraft.block;

import malicedev.buildcraft.block.entity.LandMarkerBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.util.Identifier;

public class LandMarkerBlock extends MarkerBlock {
    public LandMarkerBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new LandMarkerBlockEntity();
    }
}
