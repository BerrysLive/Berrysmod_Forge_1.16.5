package com.berry.berrysmod.block;

import com.berry.berrysmod.BerrysMod;
import com.berry.berrysmod.block.custom.CrusherBlock;
import com.berry.berrysmod.block.custom.LightningChannelerBlock;
import com.berry.berrysmod.block.custom.SmelterBlock;
import com.berry.berrysmod.item.ModItemGroup;
import com.berry.berrysmod.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BerrysMod.MOD_ID);
    //--------------------------------------------------------------------------------------------------------------------
    //Copper
    public static final RegistryObject<Block> COPPER_ORE = registerBlock("copper_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));
    public static final RegistryObject<Block> COPPER_BLOCK = registerBlock("copper_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));
    //--------------------------------------------------------------------------------------------------------------------
    //Tin
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));
    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));
    //--------------------------------------------------------------------------------------------------------------------
    //Lead
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));
    //--------------------------------------------------------------------------------------------------------------------
    //Machine Stuff
    public static final RegistryObject<Block> BASIC_MACHINE_CASING = registerBlock("basic_machine_casing",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));

    public static final RegistryObject<Block> CRUSHER = registerBlock("crusher",
            () -> new CrusherBlock(AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> SMELTER = registerBlock("smelter",
            () -> new SmelterBlock(AbstractBlock.Properties.create(Material.IRON)));
    //--------------------------------------------------------------------------------------------------------------------
    //MISC
    public static final RegistryObject<Block> LIGHTNING_CHANNELER = registerBlock("lightning_channeler",
            () -> new LightningChannelerBlock(AbstractBlock.Properties.create(Material.IRON)));

    //--------------------------------------------------------------------------------------------------------------------

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}