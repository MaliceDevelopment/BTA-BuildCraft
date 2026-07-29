package malicedev.buildcraft.compat.ami.enginecoolant;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.api.energy.EngineCoolant;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeHandler;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

public class EngineCoolantRecipeHandler implements RecipeHandler<EngineCoolant> {
    @Override
    public @NotNull Class<EngineCoolant> getRecipeClass() {
        return EngineCoolant.class;
    }

    @Override
    public @NotNull String getRecipeCategoryUid() {
        return Buildcraft.NAMESPACE.id("engine_coolant").toString();
    }

    @Override
    public @NotNull RecipeWrapper getRecipeWrapper(@NotNull EngineCoolant recipe) {
        return new EngineCoolantRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(@NotNull EngineCoolant recipe) {
        return true;
    }
}
