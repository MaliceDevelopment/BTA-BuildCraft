package malicedev.buildcraft.init;

import malicedev.buildcraft.block.entity.*;
import malicedev.buildcraft.block.entity.pipe.DiamondPipeBlockEntity;
import malicedev.buildcraft.block.entity.pipe.PipeBlockEntity;
import malicedev.buildcraft.screen.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.Container;
import net.modificationstation.stationapi.api.client.gui.screen.GuiHandler;
import net.modificationstation.stationapi.api.event.registry.GuiHandlerRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.network.packet.MessagePacket;
import net.modificationstation.stationapi.api.util.Namespace;

public class ScreenHandlerListener {

    @Entrypoint.Namespace
    public static Namespace NAMESPACE;

    @EventListener
    public void registerScreenHandlers(GuiHandlerRegistryEvent event) {
        event.register(NAMESPACE.id("chute_screen"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openChuteScreen, ChuteBlockEntity::new));
        event.register(NAMESPACE.id("stirling_engine"), new GuiHandler(this::openStirlingEngineScreen, StirlingEngineBlockEntity::new));
        event.register(NAMESPACE.id("combustion_engine"), new GuiHandler(this::openCombustionEngineScreen, CombustionEngineBlockEntity::new));
        event.register(NAMESPACE.id("autocrafting_table"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openAutocraftingTableScreen, AutocraftingTableBlockEntity::new));
        event.register(NAMESPACE.id("assembly_table"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openAssemblyTableScreen, AssemblyTableBlockEntity::new));
        event.register(NAMESPACE.id("integration_table"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openIntegrationTableScreen, IntegrationTableBlockEntity::new));
        event.register(NAMESPACE.id("gate"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openGateScreen, PipeBlockEntity::new));
        event.register(NAMESPACE.id("diamond_pipe"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openDiamondPipeScreen, DiamondPipeBlockEntity::new));
        event.register(NAMESPACE.id("architect_table"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openArchitectTableScreen, ArchitectTableBlockEntity::new));
        event.register(NAMESPACE.id("builder"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openBuilderScreen, BuilderBlockEntity::new));
        event.register(NAMESPACE.id("blueprint_library"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage) this::openBlueprintLibrary, BlueprintLibraryBlockEntity::new));
    }

    private Screen openBlueprintLibrary(Player player, Inventory inventory) {
        return new BlueprintLibraryScreen(player, (BlueprintLibraryBlockEntity) inventory);
    }

    private Screen openBuilderScreen(Player player, Inventory inventory) {
        return new BuilderScreen(player, (BuilderBlockEntity) inventory);
    }

    private Screen openArchitectTableScreen(Player player, Inventory inventory) {
        return new ArchitectTableScreen(player, (ArchitectTableBlockEntity) inventory);
    }

    public Screen openDiamondPipeScreen(Player player, Inventory inventory) {
        return new DiamondPipeScreen(player, (DiamondPipeBlockEntity) inventory);
    }

    public Screen openChuteScreen(Player playerEntity, Inventory inventory) {
        return new ChuteScreen(playerEntity.inventory, (ChuteBlockEntity) inventory);
    }

    public Screen openStirlingEngineScreen(Player playerEntity, Inventory inventory, MessagePacket message) {
        BlockEntity blockEntity = playerEntity.world.getBlockEntity(message.ints[1], message.ints[2], message.ints[3]);
        if(blockEntity instanceof StirlingEngineBlockEntity engine) {
            return new StirlingEngineScreen(playerEntity, engine);
        }
        return null;
    }

    public Screen openCombustionEngineScreen(Player playerEntity, Inventory inventory,  MessagePacket message) {
        BlockEntity blockEntity = playerEntity.world.getBlockEntity(message.ints[1], message.ints[2], message.ints[3]);
        if(blockEntity instanceof CombustionEngineBlockEntity engine) {
            return new CombustionEngineScreen(playerEntity, engine);
        }
        return null;
    }

    public Screen openAutocraftingTableScreen(Player playerEntity, Inventory inventory) {
        return new AutocraftingTableScreen(playerEntity, (AutocraftingTableBlockEntity) inventory);
    }

    public Screen openAssemblyTableScreen(Player playerEntity, Inventory inventory) {
        return new AssemblyTableScreen(playerEntity, (AssemblyTableBlockEntity) inventory);
    }

    private Screen openIntegrationTableScreen(Player player, Inventory inventory) {
        return new IntegrationTableScreen(player, (IntegrationTableBlockEntity) inventory);
    }

    public Screen openGateScreen(Player playerEntity, Inventory inventory) {
        return new GateInterfaceScreen(playerEntity.inventory, (PipeBlockEntity) inventory);
    }
}
