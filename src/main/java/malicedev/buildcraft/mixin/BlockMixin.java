package malicedev.buildcraft.mixin;

import malicedev.buildcraft.registry.PluggableRegisterEvent;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.StationAPI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "<clinit>", at = @At("HEAD"))
    private static void firePluggableRegisterEvent(CallbackInfo ci){
        StationAPI.EVENT_BUS.post(new PluggableRegisterEvent());
    }
}
