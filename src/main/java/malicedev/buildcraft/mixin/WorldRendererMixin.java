package malicedev.buildcraft.mixin;

import malicedev.buildcraft.Buildcraft;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @Inject(method = "renderBlockOutline", at =  @At("HEAD"))
    public void setTickDelta(Player player, HitResult hitResult, int i, ItemStack stack, float tickDelta, CallbackInfo ci){
        Buildcraft.tickDelta = tickDelta;
    }
}
