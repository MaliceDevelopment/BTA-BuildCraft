package malicedev.buildcraft.compat.ami.enginefuel;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.api.energy.EngineFuel;
import malicedev.buildcraft.compat.ami.FluidRecipeWrapper;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeHandler;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class EngineFuelRecipeHandler implements RecipeHandler<EngineFuel> {
    @Override
    public @NotNull Class<EngineFuel> getRecipeClass() {
        return EngineFuel.class;
    }

    @Override
    public @NotNull String getRecipeCategoryUid() {
        return Buildcraft.NAMESPACE.id("engine_fuel").toString();
    }

    @Override
    public @NotNull RecipeWrapper getRecipeWrapper(@NotNull EngineFuel recipe) {
        return new EngineFuelRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(@NotNull EngineFuel recipe) {
        return true;
    }
}
