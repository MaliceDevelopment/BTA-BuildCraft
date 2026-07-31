package malicedev.buildcraft;

import malicedev.buildcraft.block.*;
import malicedev.buildcraft.block.entity.pipe.*;
import malicedev.buildcraft.block.entity.pipe.behavior.*;
import malicedev.buildcraft.block.entity.pipe.gate.GateLogic;
import malicedev.buildcraft.block.entity.pipe.gate.GateMaterial;
import malicedev.buildcraft.block.entity.pipe.transporter.EnergyPipeTransporter;
import malicedev.buildcraft.block.entity.pipe.transporter.FluidPipeTransporter;
import malicedev.buildcraft.block.entity.pipe.transporter.ItemPipeTransporter;
import malicedev.buildcraft.block.entity.pipe.transporter.StructurePipeTransporter;
import malicedev.buildcraft.block.material.PipeMaterial;
import malicedev.buildcraft.event.StatementRegisterEvent;
import malicedev.buildcraft.item.*;
import malicedev.buildcraft.util.ColorUtil;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
//import net.minecraft.block.MapColor;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.item.Item;
import net.modificationstation.stationapi.api.StationAPI;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Namespace;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.dependency.Key;

import java.util.Properties;

public class Buildcraft implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("buildcraft", true);
	public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static int blockId;
	public static int itemId;
	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id","8300");
		prop.setProperty("starting_item_id","25700");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);

		blockId = config.getInt("starting_block_id");
		itemId = config.getInt("starting_item_id");

		config.updateConfig();
	}

	@Override
	public void onInitialize() {
		CommonEvents.BEFORE_GAME_START.listen(Key.of(MOD_ID), this::beforeGameStart);
		CommonEvents.AFTER_GAME_START.listen(Key.of(MOD_ID), this::afterGameStart);
		CommonEvents.AFTER_BLOCK_INIT.listen(Key.of(MOD_ID),this::registerBlocks);
		CommonEvents.AFTER_ITEM_INIT.listen(Key.of(MOD_ID),this::registerItems);
		LOGGER.info("ExampleMod initialized.");
	}

	public void beforeGameStart() {

	}

	public void afterGameStart() {

	}

	public String NAMESPACE = "buildcraft:";

    public static Item wrench;
    public static Item woodenGear;
    public static Item stoneGear;
    public static Item ironGear;
    public static Item goldGear;
    public static Item diamondGear;
    public static Item template;
    public static Item blueprint;
    public static Item pipeSealant;

    public static Item redPipeWire;
    public static Item bluePipeWire;
    public static Item greenPipeWire;
    public static Item yellowPipeWire;

    public static Item redstoneChipset;
    public static Item redstoneIronChipset;
    public static Item redstoneGoldenChipset;
    public static Item redstoneDiamondChipset;
    public static Item redstoneEmeraldChipset;
    public static Item redstoneGlowstoneChipset;
    public static Item pulsatingChipset;
    public static Item redstoneCompChipset;

    public static Item paintbrush;
    public static Item[] paintbrushes = new Item[16];

    public static Item[] lens = new Item[16];
    public static Item[] filter = new Item[16];

    public static Item plug;
    public static Item facade;

    public static Item[] gates;
    public static Item gateCopier;

    public static Material pipeMaterial;

    public static Block chuteBlock;
    public static Block goldenChuteBlock;
    public static Block autoWorkbench;
    public static Block miningWell;
    public static Block quarry;
    public static Block pump;
    public static Block floodGate;
    public static Block tank;
    public static Block refinery;
    public static Block laser;
    public static Block assemblyTable;
    public static Block integrationTable;
    public static Block filler;
    public static Block builder;
    public static Block architectTable;
    public static Block blueprintLibrary;
    public static Block landMarker;
    public static Block pathMarker;
    public static Block redstoneEngine;
    public static Block stirlingEngine;
    public static Block combustionEngine;
    public static Block creativeEngine;

    public static Block miningPipe;
    public static Block frame;

    public static WoodenPipeBehavior woodenPipeBehavior;
    public static CobblestonePipeBehavior cobblestonePipeBehavior;
    public static StonePipeBehavior stonePipeBehavior;
    public static IronPipeBehavior ironPipeBehavior;
    public static SandstonePipeBehavior sandstonePipeBehavior;
    public static GoldenPipeBehavior goldenPipeBehavior;
    public static DiamondPipeBehavior diamondPipeBehavior;
    public static ObsidianPipeBehavior obsidianPipeBehavior;
    public static ClayPipeBehavior clayPipeBehavior;
    public static VoidPipeBehavior voidPipeBehavior;
    public static StructurePipeBehavior structurePipeBehavior;

    public static Block cobblestoneStructurePipe;

    public static Block woodenItemPipe;
    public static Block cobblestoneItemPipe;
    public static Block stoneItemPipe;
    public static Block ironItemPipe;
    public static Block sandstoneItemPipe;
    public static Block goldenItemPipe;
    public static Block diamondItemPipe;
    public static Block obsidianItemPipe;
    public static Block clayItemPipe;
    public static Block voidItemPipe;

    public static Block woodenFluidPipe;
    public static Block cobblestoneFluidPipe;
    public static Block stoneFluidPipe;
    public static Block ironFluidPipe;
    public static Block sandstoneFluidPipe;
    public static Block goldenFluidPipe;
    public static Block diamondFluidPipe;
    public static Block voidFluidPipe;

    public static Block woodenEnergyPipe;
    public static Block cobblestoneEnergyPipe;
    public static Block stoneEnergyPipe;
    public static Block ironEnergyPipe;
    public static Block sandstoneEnergyPipe;
    public static Block goldenEnergyPipe;
    public static Block diamondEnergyPipe;

    public static RenderBlock renderBlock;
    public static float tickDelta;


    public void registerItems() {
        wrench = new BuildcraftWrenchItem(NAMESPACE.id("wrench", NAMESPACE+"item/"+"wrench");
        woodenGear = new ItemBuilder(MOD_ID).build(new Item("wooden_gear", NAMESPACE+"item/"+"wooden_gear",itemId++));
        stoneGear = new ItemBuilder(MOD_ID).build(new Item("stone_gear", NAMESPACE+"item/"+"stone_gear",itemId++));
        ironGear = new ItemBuilder(MOD_ID).build(new Item("iron_gear", NAMESPACE+"item/"+"iron_gear",itemId++));
        goldGear = new ItemBuilder(MOD_ID).build(new Item("golden_gear", NAMESPACE+"item/"+"golden_gear",itemId++));
        diamondGear = new ItemBuilder(MOD_ID).build(new Item("diamond_gear", NAMESPACE+"item/"+ "diamond_gear",itemId++));
        template = new BuilderTemplateItem(NAMESPACE.id("template", NAMESPACE+"item/"+ "template"));
        blueprint = new BuilderBlueprintItem(NAMESPACE.id("blueprint", NAMESPACE+"item/"+ "blueprint"));
        pipeSealant = new ItemBuilder(MOD_ID).build(new Item("pipe_sealant", NAMESPACE+"item/"+ "pipe_sealant",itemId++));

        redPipeWire = new ItemBuilder(MOD_ID).build(new PipeWireItem("red_pipe_wire", NAMESPACE+"item/"+ "red_pipe_wire",itemId++));
        bluePipeWire = new ItemBuilder(MOD_ID).build(new PipeWireItem("blue_pipe_wire", NAMESPACE+"item/"+ "blue_pipe_wire",itemId++));
        greenPipeWire = new ItemBuilder(MOD_ID).build(new PipeWireItem("green_pipe_wire", NAMESPACE+"item/"+ "green_pipe_wire",itemId++));
        yellowPipeWire = new ItemBuilder(MOD_ID).build(new PipeWireItem("yellow_pipe_wire", NAMESPACE+"item/"+ "yellow_pipe_wire",itemId++));

        redstoneChipset = new ItemBuilder(MOD_ID).build(new Item("redstone_chipset", NAMESPACE+"item/"+ "redstone_chipset",itemId++));
        redstoneIronChipset = new ItemBuilder(MOD_ID).build(new Item("redstone_iron_chipset", NAMESPACE+"item/"+ "redstone_iron_chipset",itemId++));
        redstoneGoldenChipset = new ItemBuilder(MOD_ID).build(new Item("redstone_golden_chipset", NAMESPACE+"item/"+ "redstone_golden_chipset",itemId++));
        redstoneDiamondChipset = new ItemBuilder(MOD_ID).build(new Item("redstone_diamond_chipset", NAMESPACE+"item/"+ "redstone_diamond_chipset",itemId++));
        redstoneEmeraldChipset = new ItemBuilder(MOD_ID).build(new Item("redstone_emerald_chipset", NAMESPACE+"item/"+ "redstone_emerald_chipset",itemId++));
        redstoneGlowstoneChipset = new ItemBuilder(MOD_ID).build(new Item("redstone_glowstone_chipset", NAMESPACE+"item/"+ "redstone_glowstone_chipset",itemId++));
        pulsatingChipset = new ItemBuilder(MOD_ID).build(new Item("pulsating_chipset", NAMESPACE+"item/"+ "pulsating_chipset",itemId++));
        redstoneCompChipset = new ItemBuilder(MOD_ID).build(new Item("redstone_comp_chipset", NAMESPACE+"item/"+ "redstone_comp_chipset",itemId++));

        paintbrush = new PaintBrushItem(NAMESPACE.id("clean_paintbrush"), -1).setTranslationKey(NAMESPACE, "clean_paintbrush");
        for (int i = 0; i < ColorUtil.colors.length; i++) {
            paintbrushes[i] = new PaintBrushItem(i).setTranslationKey(NAMESPACE, ColorUtil.getName(i) + "_paintbrush");
        }

        for (int i = 0; i < ColorUtil.colors.length; i++) {
            lens[i] = new LensItem(i, false).setTranslationKey(NAMESPACE, ColorUtil.getName(i) + "_lens");
        }

        for (int i = 0; i < ColorUtil.colors.length; i++) {
            filter[i] = new LensItem(i, true).setTranslationKey(NAMESPACE, ColorUtil.getName(i) + "_filter");
        }

        plug = new PlugItem(NAMESPACE.id("plug", NAMESPACE+"item/"+ "plug",itemId++));
        facade = new FacadeItem(NAMESPACE.id("facade", NAMESPACE+"item/"+ "facade",itemId++));

        StationAPI.EVENT_BUS.post(new StatementRegisterEvent());

        gates = new Item[GateMaterial.VALUES.length * GateLogic.VALUES.length];
        for(int i = 0; i < GateMaterial.VALUES.length; i++){
            for(int j = 0; j < GateLogic.VALUES.length; j++){
                gates[i + j] = new GateItem(GateMaterial.fromOrdinal(i), GateLogic.fromOrdinal(j, NAMESPACE+"item/"+ GateItem.getIdentifier(GateMaterial.fromOrdinal(i), GateLogic.fromOrdinal(j)).path);
            }
        }

        gateCopier = new GateCopierItem(NAMESPACE.id("gate_copier", NAMESPACE+"item/"+ "gate_copier",itemId++));
    }

    public void registerBlocks() {
        pipeMaterial = new PipeMaterial(MaterialColor.LIGHT_GRAY);

        woodenPipeBehavior = new WoodenPipeBehavior();
        cobblestonePipeBehavior = new CobblestonePipeBehavior();
        stonePipeBehavior = new StonePipeBehavior();
        ironPipeBehavior = new IronPipeBehavior();
        sandstonePipeBehavior = new SandstonePipeBehavior();
        goldenPipeBehavior = new GoldenPipeBehavior();
        diamondPipeBehavior = new DiamondPipeBehavior();
        obsidianPipeBehavior = new ObsidianPipeBehavior();
        clayPipeBehavior = new ClayPipeBehavior();
        voidPipeBehavior = new VoidPipeBehavior();
        structurePipeBehavior = new StructurePipeBehavior();

        chuteBlock = new ChuteBlock(NAMESPACE.id("chute")).setTranslationKey(NAMESPACE, "chute").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        goldenChuteBlock = new GoldenChuteBlock(NAMESPACE.id("golden_chute")).setTranslationKey(NAMESPACE, "golden_chute").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        autoWorkbench = new AutocraftingTableBlock(NAMESPACE.id("autocrafting_table"), Material.WOOD).setTranslationKey(NAMESPACE, "auto_workbench").setHardness(2.5F);
        miningWell = new MiningWellBlock(NAMESPACE.id("mining_well"), Material.METAL).setTranslationKey(NAMESPACE, "mining_well").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        quarry = new QuarryBlock(NAMESPACE.id("quarry"), Material.METAL).setTranslationKey(NAMESPACE, "quarry").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        pump = new PumpBlock(NAMESPACE.id("pump"), Material.METAL).setTranslationKey(NAMESPACE, "pump").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        pump = new FloodGateBlock(NAMESPACE.id("flood_gate"), Material.METAL).setTranslationKey(NAMESPACE, "flood_gate").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        tank = new TankBlock(NAMESPACE.id("tank")).setTranslationKey(NAMESPACE, "tank").setHardness(0.5F);
        refinery = new RefineryBlock(NAMESPACE.id("refinery"), Material.METAL).setTranslationKey(NAMESPACE, "refinery").setHardness(3.0F);
        laser = new LaserBlock(NAMESPACE.id("laser"), Material.METAL).setTranslationKey(NAMESPACE, "laser").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        assemblyTable = new AssemblyTableBlock(NAMESPACE.id("assembly_table"), Material.METAL).setTranslationKey(NAMESPACE, "assembly_table").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        integrationTable = new IntegrationTableBlock(NAMESPACE.id("integration_table"), Material.METAL).setTranslationKey(NAMESPACE, "integration_table").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        filler = new FillerBlock(NAMESPACE.id("filler"), Material.METAL).setTranslationKey(NAMESPACE, "filler").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        builder = new BuilderBlock(NAMESPACE.id("builder"), Material.METAL).setTranslationKey(NAMESPACE, "builder").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        architectTable = new ArchitectTableBlock(NAMESPACE.id("architect_table"), Material.METAL).setTranslationKey(NAMESPACE, "architect_table").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        blueprintLibrary = new BlueprintLibraryBlock(NAMESPACE.id("blueprint_library"), Material.METAL).setTranslationKey(NAMESPACE, "blueprint_library").setHardness(3.0F).setSoundGroup(Block.METAL_SOUND_GROUP);
        landMarker = new LandMarkerBlock(NAMESPACE.id("land_marker"), Material.PISTON_BREAKABLE).setTranslationKey(NAMESPACE, "land_marker");
        pathMarker = new PathMarkerBlock(NAMESPACE.id("path_marker"), Material.PISTON_BREAKABLE).setTranslationKey(NAMESPACE, "path_marker");
        redstoneEngine = new RedstoneEngineBlock(NAMESPACE.id("redstone_engine")).setTranslationKey(NAMESPACE, "redstone_engine").setHardness(0.7F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        stirlingEngine = new StirlingEngineBlock(NAMESPACE.id("stirling_engine")).setTranslationKey(NAMESPACE, "stirling_engine").setHardness(1.0F).setSoundGroup(Block.STONE_SOUND_GROUP);
        combustionEngine = new CombustionEngineBlock(NAMESPACE.id("combustion_engine")).setTranslationKey(NAMESPACE, "combustion_engine").setHardness(1.2F).setSoundGroup(Block.METAL_SOUND_GROUP);
        creativeEngine = new CreativeEngineBlock(NAMESPACE.id("creative_engine")).setTranslationKey(NAMESPACE, "creative_engine").setHardness(1.2F).setSoundGroup(Block.METAL_SOUND_GROUP);

        miningPipe = new MiningPipeBlock(NAMESPACE.id("mining_pipe"), pipeMaterial).setTranslationKey(NAMESPACE, "mining_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);
        frame = new FrameBlock(NAMESPACE.id("frame"), pipeMaterial).setTranslationKey(NAMESPACE, "frame").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);

        renderBlock = new RenderBlock(NAMESPACE.id("render_block"));

        // Structure Pipes
        cobblestoneStructurePipe = new PipeBlock(
                NAMESPACE.id("cobblestone_structure_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/cobblestone_structure_pipe"),
                null,
                PipeType.STRUCTURE,
                structurePipeBehavior,
                StructurePipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "cobblestone_structure_pipe").setHardness(0.1F).setSoundGroup(Block.STONE_SOUND_GROUP);

        // Item Pipes
        woodenItemPipe = new PipeBlock(
                NAMESPACE.id("wooden_item_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/wooden_item_pipe"),
                NAMESPACE.id("block/pipe/wooden_item_pipe_alternative"),
                PipeType.ITEM,
                woodenPipeBehavior,
                ItemPipeTransporter::new,
                PoweredPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "wooden_item_pipe").setHardness(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);

        cobblestoneItemPipe = new PipeBlock(
                NAMESPACE.id("cobblestone_item_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/cobblestone_item_pipe"),
                null,
                PipeType.ITEM,
                cobblestonePipeBehavior,
                ItemPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "cobblestone_item_pipe").setHardness(0.1F).setSoundGroup(Block.STONE_SOUND_GROUP);

        stoneItemPipe = new PipeBlock(
                NAMESPACE.id("stone_item_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/stone_item_pipe"),
                null,
                PipeType.ITEM,
                stonePipeBehavior,
                ItemPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "stone_item_pipe").setHardness(0.1F).setSoundGroup(Block.STONE_SOUND_GROUP);

        ironItemPipe = new PipeBlock(
                NAMESPACE.id("iron_item_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/iron_item_pipe"),
                NAMESPACE.id("block/pipe/iron_item_pipe_alternative"),
                PipeType.ITEM,
                ironPipeBehavior,
                ItemPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "iron_item_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);

        sandstoneItemPipe = new PipeBlock(
                NAMESPACE.id("sandstone_item_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/sandstone_item_pipe"),
                null,
                PipeType.ITEM,
                sandstonePipeBehavior,
                ItemPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "sandstone_item_pipe").setHardness(0.1F).setSoundGroup(Block.STONE_SOUND_GROUP);

        goldenItemPipe = new PipeBlock(
                NAMESPACE.id("golden_item_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/golden_item_pipe"),
                null,
                PipeType.ITEM,
                goldenPipeBehavior,
                ItemPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "golden_item_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);

        diamondItemPipe = new DiamondPipeBlock(
                NAMESPACE.id("diamond_item_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/diamond_item_pipe"),
                null,
                PipeType.ITEM,
                diamondPipeBehavior,
                ItemPipeTransporter::new,
                DiamondPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "diamond_item_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);

        obsidianItemPipe = new PipeBlock(
                NAMESPACE.id("obsidian_item_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/obsidian_item_pipe"),
                null,
                PipeType.ITEM,
                obsidianPipeBehavior,
                ItemPipeTransporter::new,
                ObsidianPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "obsidian_item_pipe").setHardness(0.1F).setSoundGroup(Block.STONE_SOUND_GROUP);

        clayItemPipe = new PipeBlock(
                NAMESPACE.id("clay_item_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/clay_item_pipe"),
                null,
                PipeType.ITEM,
                clayPipeBehavior,
                ItemPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "clay_item_pipe").setHardness(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);

        voidItemPipe = new PipeBlock(
                NAMESPACE.id("void_item_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/void_item_pipe"),
                null,
                PipeType.ITEM,
                voidPipeBehavior,
                ItemPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "void_item_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);

        // Fluid Pipes
        woodenFluidPipe = new PipeBlock(
                NAMESPACE.id("wooden_fluid_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/wooden_fluid_pipe"),
                NAMESPACE.id("block/pipe/wooden_fluid_pipe_alternative"),
                PipeType.FLUID,
                woodenPipeBehavior,
                FluidPipeTransporter::new,
                PoweredPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "wooden_fluid_pipe").setHardness(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);

        cobblestoneFluidPipe = new PipeBlock(
                NAMESPACE.id("cobblestone_fluid_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/cobblestone_fluid_pipe"),
                null,
                PipeType.FLUID,
                cobblestonePipeBehavior,
                FluidPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "cobblestone_fluid_pipe").setHardness(0.1F).setSoundGroup(Block.STONE_SOUND_GROUP);

        stoneFluidPipe = new PipeBlock(
                NAMESPACE.id("stone_fluid_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/stone_fluid_pipe"),
                null,
                PipeType.FLUID,
                stonePipeBehavior,
                FluidPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "stone_fluid_pipe").setHardness(0.1F).setSoundGroup(Block.STONE_SOUND_GROUP);

        ironFluidPipe = new PipeBlock(
                NAMESPACE.id("iron_fluid_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/iron_fluid_pipe"),
                NAMESPACE.id("block/pipe/iron_fluid_pipe_alternative"),
                PipeType.FLUID,
                ironPipeBehavior,
                FluidPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "iron_fluid_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);

        sandstoneFluidPipe = new PipeBlock(
                NAMESPACE.id("sandstone_fluid_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/sandstone_fluid_pipe"),
                null,
                PipeType.FLUID,
                sandstonePipeBehavior,
                FluidPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "sandstone_fluid_pipe").setHardness(0.1F).setSoundGroup(Block.STONE_SOUND_GROUP);

        goldenFluidPipe = new PipeBlock(
                NAMESPACE.id("golden_fluid_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/golden_fluid_pipe"),
                null,
                PipeType.FLUID,
                goldenPipeBehavior,
                FluidPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "golden_fluid_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);

        diamondFluidPipe = new DiamondPipeBlock(
                NAMESPACE.id("diamond_fluid_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/diamond_fluid_pipe"),
                null,
                PipeType.FLUID,
                diamondPipeBehavior,
                FluidPipeTransporter::new,
                DiamondPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "diamond_fluid_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);

        voidFluidPipe = new PipeBlock(
                NAMESPACE.id("void_fluid_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/void_fluid_pipe"),
                null,
                PipeType.FLUID,
                voidPipeBehavior,
                FluidPipeTransporter::new,
                PipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "void_fluid_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);

        // Energy Pipes
        woodenEnergyPipe = new PipeBlock(
                NAMESPACE.id("wooden_energy_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/wooden_energy_pipe"),
                NAMESPACE.id("block/pipe/wooden_energy_pipe_alternative"),
                PipeType.ENERGY,
                woodenPipeBehavior,
                EnergyPipeTransporter::new,
                PoweredPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "wooden_energy_pipe").setHardness(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);

        cobblestoneEnergyPipe = new PipeBlock(
                NAMESPACE.id("cobblestone_energy_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/cobblestone_energy_pipe"),
                null,
                PipeType.ENERGY,
                cobblestonePipeBehavior,
                EnergyPipeTransporter::new,
                PoweredPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "cobblestone_energy_pipe").setHardness(0.1F).setSoundGroup(Block.STONE_SOUND_GROUP);

        stoneEnergyPipe = new PipeBlock(
                NAMESPACE.id("stone_energy_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/stone_energy_pipe"),
                null,
                PipeType.ENERGY,
                stonePipeBehavior,
                EnergyPipeTransporter::new,
                PoweredPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "stone_energy_pipe").setHardness(0.1F).setSoundGroup(Block.STONE_SOUND_GROUP);

        ironEnergyPipe = new PipeBlock(
                NAMESPACE.id("iron_energy_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/iron_energy_pipe"),
                null,
                PipeType.ENERGY,
                ironPipeBehavior,
                EnergyPipeTransporter::new,
                PoweredPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "iron_energy_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);

        sandstoneEnergyPipe = new PipeBlock(
                NAMESPACE.id("sandstone_energy_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/sandstone_energy_pipe"),
                null,
                PipeType.ENERGY,
                sandstonePipeBehavior,
                EnergyPipeTransporter::new,
                PoweredPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "sandstone_energy_pipe").setHardness(0.1F).setSoundGroup(Block.STONE_SOUND_GROUP);

        goldenEnergyPipe = new PipeBlock(
                NAMESPACE.id("golden_energy_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/golden_energy_pipe"),
                null,
                PipeType.ENERGY,
                goldenPipeBehavior,
                EnergyPipeTransporter::new,
                PoweredPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "golden_energy_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);

        diamondEnergyPipe = new PipeBlock(
                NAMESPACE.id("diamond_energy_pipe"),
                pipeMaterial,
                NAMESPACE.id("block/pipe/diamond_energy_pipe"),
                null,
                PipeType.ENERGY,
                diamondPipeBehavior,
                EnergyPipeTransporter::new,
                PoweredPipeBlockEntity::new
        ).setTranslationKey(NAMESPACE, "diamond_energy_pipe").setHardness(0.1F).setSoundGroup(Block.METAL_SOUND_GROUP);
    }
}
