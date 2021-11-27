package com.berry.berrysmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup BERRYSMOD_GROUP = new ItemGroup("BerrysMod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_INGOT.get());
        }
    };
}
