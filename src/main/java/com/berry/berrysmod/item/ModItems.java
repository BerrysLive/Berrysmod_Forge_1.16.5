package com.berry.berrysmod.item;

import com.berry.berrysmod.BerrysMod;
import com.berry.berrysmod.item.custom.WireCutters;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BerrysMod.MOD_ID);
    //--------------------------------------------------------------------------------------------------------------------
    //Copper
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));

    public static final RegistryObject<Item> RAW_COPPER = ITEMS.register("raw_copper",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));

    public static final RegistryObject<Item> COPPER_WIRE = ITEMS.register("copper_wire",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    //--------------------------------------------------------------------------------------------------------------------
    //Tin
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));

    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    public static final RegistryObject<Item> TIN_DUST = ITEMS.register("tin_dust",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    //--------------------------------------------------------------------------------------------------------------------
    //Tin
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));

    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    public static final RegistryObject<Item> LEAD_DUST = ITEMS.register("lead_dust",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    //--------------------------------------------------------------------------------------------------------------------
    //Steel
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    //--------------------------------------------------------------------------------------------------------------------
    //Iron
    public static final RegistryObject<Item> IRON_ROD = ITEMS.register("iron_rod",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    //--------------------------------------------------------------------------------------------------------------------
    //Tools
    public static final RegistryObject<Item> WIRE_CUTTERS = ITEMS.register("wire_cutters",
            () -> new WireCutters(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP).maxDamage(64)));
    //--------------------------------------------------------------------------------------------------------------------
    //Machine Stuff
    public static final RegistryObject<Item> CIRCUIT = ITEMS.register("circuit",
            ()->new Item(new Item.Properties().group(ModItemGroup.BERRYSMOD_GROUP)));
    //--------------------------------------------------------------------------------------------------------------------
    //


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
