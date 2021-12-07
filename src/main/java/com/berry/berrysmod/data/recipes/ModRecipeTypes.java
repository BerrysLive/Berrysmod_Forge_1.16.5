package com.berry.berrysmod.data.recipes;

import com.berry.berrysmod.BerrysMod;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeTypes {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, BerrysMod.MOD_ID);

    public static final RegistryObject<CrusherRecipe.Serializer> CRUSHER_SERIALIZER = RECIPE_SERIALIZER.register(
            "crusher",CrusherRecipe.Serializer::new);

    public static IRecipeType<CrusherRecipe> CRUSHER_RECIPE = new CrusherRecipe.CrusherRecipeType();

    public static void register(IEventBus eventBus){
        RECIPE_SERIALIZER.register(eventBus);

        Registry.register(Registry.RECIPE_TYPE, CrusherRecipe.TYPE_ID, CRUSHER_RECIPE);
    }

}
