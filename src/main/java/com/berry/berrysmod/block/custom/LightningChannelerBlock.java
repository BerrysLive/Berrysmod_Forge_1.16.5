package com.berry.berrysmod.block.custom;

import com.berry.berrysmod.container.LightningChannelerContainer;
import com.berry.berrysmod.tileentity.LightningChannelerTile;
import com.berry.berrysmod.tileentity.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class LightningChannelerBlock extends Block {
    public LightningChannelerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()){
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            //bellow is  not needed for every tile entity from here
//-----------------------------------------------------------------------------------------------------------------------------
            if(!player.isCrouching()){
            //to Here
//------------------------------------------------------------------------------------------------------------------------------------------

                if(tileEntity instanceof LightningChannelerTile){
                    INamedContainerProvider containerProvider = createContainerProvider(worldIn,pos);
                    NetworkHooks.openGui(((ServerPlayerEntity) player),containerProvider,tileEntity.getPos());
                }
                else {
                    throw new IllegalStateException("Our Container provider is missing!");
                }
            }
            //and here
//------------------------------------------------------------------------------------------------------------------------------------------

            else {
                if(tileEntity instanceof LightningChannelerTile){
                    if(worldIn.isThundering()){
                        EntityType.LIGHTNING_BOLT.spawn(((ServerWorld)worldIn),null,player,pos, SpawnReason.TRIGGERED
                                ,true,true);

                        ((LightningChannelerTile)tileEntity).lightningHasStruck();
                    }
                }
            }
            //To Here
// -----------------------------------------------------------------------------------------------------------------------------

        }
        return ActionResultType.SUCCESS;
    }
//Not needed for all Tile Entities from Here
//------------------------------------------------------------------------------------------------------------------------------------------
    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.berrysmod.lightning_channeler");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new LightningChannelerContainer(i, worldIn,pos,playerInventory,playerEntity);
            }
        };
    }
    //To here
//------------------------------------------------------------------------------------------------------------------------------------------


    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.LIGHTNING_CHANNLER_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
