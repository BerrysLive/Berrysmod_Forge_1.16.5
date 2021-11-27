package com.berry.berrysmod.block;

import com.berry.berrysmod.BerrysMod;
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
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BerrysMod.MOD_ID);


    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore",
            ()->new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
