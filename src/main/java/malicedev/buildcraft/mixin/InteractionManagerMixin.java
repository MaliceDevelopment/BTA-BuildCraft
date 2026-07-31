package malicedev.buildcraft.mixin;

import malicedev.buildcraft.block.PipeBlock;
import net.minecraft.client.InteractionManager;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InteractionManager.class)
public class InteractionManagerMixin {
    @Inject(method = "interactBlock", at = @At("HEAD"))
    public void getSide(Player player, World world, ItemStack stack, int x, int y, int z, int side, CallbackInfoReturnable<Boolean> cir){
        PipeBlock.lastSideUsed = side;
    }
}
