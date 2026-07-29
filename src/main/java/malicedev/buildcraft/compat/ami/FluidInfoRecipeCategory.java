package malicedev.buildcraft.compat.ami;

import malicedev.buildcraft.util.ScreenUtil;
import malicedev.nyalib.fluid.Fluid;
import malicedev.nyalib.fluid.FluidStack;
import net.glasslauncher.mods.alwaysmoreitems.api.gui.AMIDrawable;
import net.glasslauncher.mods.alwaysmoreitems.api.gui.RecipeLayout;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeCategory;
import net.glasslauncher.mods.alwaysmoreitems.api.recipe.RecipeWrapper;
import net.glasslauncher.mods.alwaysmoreitems.gui.DrawableHelper;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

public abstract class FluidInfoRecipeCategory implements RecipeCategory {
    private final AMIDrawable background = DrawableHelper.createDrawable("/assets/buildcraft/stationapi/textures/gui/fluidinfo_ami.png", 0, 0, 87, 60);
    private final AMIDrawable tankLines = DrawableHelper.createDrawable("/assets/buildcraft/stationapi/textures/gui/fluidinfo_ami.png", 87, 1, 16, 58);

    private Fluid fluid;

    @Override
    public @NotNull AMIDrawable getBackground() {
        return background;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        if(fluid != null) {
            ScreenUtil.drawFluid(new FluidStack(fluid), 100, 1, 1, 16, 58, 0);
            tankLines.draw(minecraft, 1, 1);
        }
    }

    @Override
    public void drawAnimations(Minecraft minecraft) {

    }

    @Override
    public void setRecipe(@NotNull RecipeLayout recipeLayout, @NotNull RecipeWrapper recipeWrapper) {
        if(recipeWrapper instanceof FluidRecipeWrapper wrapper){
            setFluid(wrapper.getFluid());
        }
    }

    protected void setFluid(Fluid fluid){
        this.fluid = fluid;
    }
}
