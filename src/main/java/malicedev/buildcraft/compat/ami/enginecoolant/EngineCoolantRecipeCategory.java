package malicedev.buildcraft.compat.ami.enginecoolant;

import malicedev.buildcraft.Buildcraft;
import malicedev.buildcraft.compat.ami.FluidInfoRecipeCategory;
import net.minecraft.client.resource.language.TranslationStorage;
import org.jetbrains.annotations.NotNull;

public class EngineCoolantRecipeCategory extends FluidInfoRecipeCategory {
    @Override
    public @NotNull String getUid() {
        return Buildcraft.NAMESPACE.id("engine_coolant").toString();
    }

    @Override
    public @NotNull String getTitle() {
        return TranslationStorage.getInstance().get("category.buildcraft.engine_coolant");
    }
}
