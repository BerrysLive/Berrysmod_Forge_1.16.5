package com.berry.berrysmod.item;

import com.berry.berrysmod.BerrysMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BerrysMod.MOD_ID);

    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot",
            ()->new Item(new Item.Properties().group(ItemGroup.MISC)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
