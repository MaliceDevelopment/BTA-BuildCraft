package malicedev.buildcraft.event;

import malicedev.buildcraft.recipe.refinery.RefineryRecipe;
import malicedev.buildcraft.recipe.refinery.RefineryRecipeRegistry;
import net.mine_diver.unsafeevents.Event;
import net.modificationstation.stationapi.api.util.Identifier;

public class RefineryRecipeRegisterEvent extends Event {
    public RefineryRecipeRegistry registry;

    public RefineryRecipeRegisterEvent() {
        registry = RefineryRecipeRegistry.getInstance();
    }

    public boolean register(Identifier identifier, RefineryRecipe recipe) {
        return RefineryRecipeRegistry.register(identifier, recipe);
    }
}
