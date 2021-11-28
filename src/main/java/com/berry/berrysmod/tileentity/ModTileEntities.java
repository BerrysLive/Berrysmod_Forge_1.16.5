package com.berry.berrysmod.tileentity;

import com.berry.berrysmod.BerrysMod;
import com.berry.berrysmod.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, BerrysMod.MOD_ID);

    public static RegistryObject<TileEntityType<LightningChannelerTile>> LIGHTNING_CHANNLER_TILE =
            TILE_ENTITIES.register("lightning_channeler_tile",
                    () -> TileEntityType.Builder.create(LightningChannelerTile::new,
                            ModBlocks.LIGHTNING_CHANNELER.get()).build(null));

    public static RegistryObject<TileEntityType<CrusherTile>> CRUSHER_TILE =
            TILE_ENTITIES.register("crusher_tile",
                    () -> TileEntityType.Builder.create(CrusherTile::new,
                            ModBlocks.CRUSHER.get()).build(null));


    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
