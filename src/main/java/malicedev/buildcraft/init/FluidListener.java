package malicedev.buildcraft.init;

import malicedev.buildcraft.api.energy.EngineCoolant;
import malicedev.buildcraft.api.energy.EngineCoolantRegistry;
import malicedev.buildcraft.api.energy.EngineFuel;
import malicedev.buildcraft.api.energy.EngineFuelRegistry;
import malicedev.buildcraft.config.Config;
import malicedev.buildcraft.event.RefineryRecipeRegisterEvent;
import malicedev.nyalib.event.AfterFluidRegistryEvent;
import malicedev.nyalib.event.FluidRegistryEvent;
import malicedev.nyalib.fluid.Fluid;
import malicedev.nyalib.fluid.FluidBuilder;
import malicedev.nyalib.fluid.Fluids;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.StationAPI;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;

public class FluidListener {
    @Entrypoint.Namespace
    public static Namespace NAMESPACE;

    public static Fluid oil;
    public static Fluid fuel;

    @EventListener
    public void registerFluids(FluidRegistryEvent event) {
        event.register(oil = new FluidBuilder(NAMESPACE.id("oil"), NAMESPACE.id("block/oil_still"), NAMESPACE.id("block/oil_flowing"))
                .color(0x000000)
                .tickRate(20)
                .movementSpeedMultiplier(0.2F)
                .build()
        );
        event.register(fuel = new FluidBuilder(NAMESPACE.id("fuel"), NAMESPACE.id("block/fuel_still"), NAMESPACE.id("block/fuel_flowing"))
                .color(0xC4C00E)
                .build()
        );
    }

    @EventListener
    public void afterFluidRegister(AfterFluidRegistryEvent event) {
        // Engine Coolants and Fuels
        EngineCoolantRegistry.register(Fluids.WATER, new EngineCoolant(Fluids.WATER, 0.0023f));
        EngineFuelRegistry.register(oil, new EngineFuel(oil, 6, (int) (10000 * Config.MACHINE_CONFIG.engine.fuelBurnTimeMultiplier)));
        EngineFuelRegistry.register(fuel, new EngineFuel(fuel, 12, (int) (50000 * Config.MACHINE_CONFIG.engine.fuelBurnTimeMultiplier)));

        // Refinery Recipes
        StationAPI.EVENT_BUS.post(new RefineryRecipeRegisterEvent());

        // Pump Blacklist
        Config.initPumpBlacklist();
    }
}
