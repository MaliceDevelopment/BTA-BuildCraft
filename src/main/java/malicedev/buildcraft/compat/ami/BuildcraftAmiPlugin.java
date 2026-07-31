package malicedev.buildcraft.compat.ami;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.api.energy.EngineCoolantRegistry;
import malicedev.buildcraft.api.energy.EngineFuelRegistry;
import malicedev.buildcraft.compat.ami.assemblytable.AssemblyTableRecipeCategory;
import malicedev.buildcraft.compat.ami.assemblytable.AssemblyTableRecipeHandler;
import malicedev.buildcraft.compat.ami.enginecoolant.EngineCoolantRecipeCategory;
import malicedev.buildcraft.compat.ami.enginecoolant.EngineCoolantRecipeHandler;
import malicedev.buildcraft.compat.ami.enginefuel.EngineFuelRecipeCategory;
import malicedev.buildcraft.compat.ami.enginefuel.EngineFuelRecipeHandler;
import malicedev.buildcraft.compat.ami.integrationtable.IntegrationTableRecipeCategory;
import malicedev.buildcraft.compat.ami.integrationtable.IntegrationTableRecipeHandler;
import malicedev.buildcraft.compat.ami.refinery.RefineryRecipeCategory;
import malicedev.buildcraft.compat.ami.refinery.RefineryRecipeHandler;
import malicedev.buildcraft.recipe.integration.IntegrationTableRecipeRegistry;
import malicedev.buildcraft.recipe.machine.AssemblyTableRecipeRegistry;
import malicedev.buildcraft.recipe.refinery.RefineryRecipeRegistry;
import net.glasslauncher.mods.alwaysmoreitems.api.*;
import net.minecraft.core.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Arrays;

public class BuildcraftAmiPlugin implements ModPluginProvider {
    @Override
    public String getName() {
        return "Buildcraft";
    }

    @Override
    public Identifier getId() {
        return Buildcraft.NAMESPACE.id("buildcraft");
    }

    @Override
    public void onAMIHelpersAvailable(AMIHelpers amiHelpers) {

    }

    @Override
    public void onItemRegistryAvailable(ItemRegistry itemRegistry) {

    }

    @Override
    public void register(ModRegistry registry) {
        registry.addRecipeCategories(new AssemblyTableRecipeCategory());
        registry.addRecipeCategories(new IntegrationTableRecipeCategory());
        registry.addRecipeCategories(new RefineryRecipeCategory());
        registry.addRecipeCategories(new EngineFuelRecipeCategory());
        registry.addRecipeCategories(new EngineCoolantRecipeCategory());

        registry.addRecipeHandlers(new AssemblyTableRecipeHandler());
        registry.addRecipeHandlers(new IntegrationTableRecipeHandler());
        registry.addRecipeHandlers(new RefineryRecipeHandler());
        registry.addRecipeHandlers(new EngineFuelRecipeHandler());
        registry.addRecipeHandlers(new EngineCoolantRecipeHandler());

        registry.addRecipes(Arrays.asList(AssemblyTableRecipeRegistry.getInstance().registry.values().toArray()));
        registry.addRecipes(Arrays.asList(IntegrationTableRecipeRegistry.getInstance().registry.values().toArray()));
        registry.addRecipes(Arrays.asList(RefineryRecipeRegistry.getRegistry().values().toArray()));
        registry.addRecipes(Arrays.asList(EngineFuelRegistry.getRegistry().values().toArray()));
        registry.addRecipes(Arrays.asList(EngineCoolantRegistry.getRegistry().values().toArray()));
    }

    @Override
    public void onRecipeRegistryAvailable(RecipeRegistry recipeRegistry) {

    }

    @Override
    public SyncableRecipe deserializeRecipe(NbtCompound recipe) {
        return null;
    }

    @Override
    public void updateBlacklist(AMIHelpers amiHelpers) {
        amiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(Buildcraft.renderBlock));
    }
}
