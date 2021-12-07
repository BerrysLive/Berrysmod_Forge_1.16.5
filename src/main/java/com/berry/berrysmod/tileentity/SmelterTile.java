package com.berry.berrysmod.tileentity;

import com.berry.berrysmod.data.recipes.CrusherRecipe;
import com.berry.berrysmod.data.recipes.ModRecipeTypes;
import com.berry.berrysmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public class SmelterTile extends TileEntity implements ITickableTileEntity {
    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(()->itemHandler);

    public SmelterTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public SmelterTile(){
        this(ModTileEntities.SMELTER_TILE.get());
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv",itemHandler.serializeNBT());
        return super.write(compound);
    }

    private ItemStackHandler createHandler(){
        //Determines how many slots are in the machine
        return new ItemStackHandler(3){
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
//                switch (slot){
//                    case 0:return stack.getItem()== Items.GLASS_PANE;
//                    case 1:
//                        return stack.getItem()== ModItems.COPPER_INGOT.get() || stack.getItem()== ModItems.WIRE_CUTTERS.get();
//                    default:
//                        return false;
//                }
                return true;
            }

//            @Override
//            public int getSlotLimit(int slot) {
//                return 1;
//            }
//            Not Useful

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot,stack)){
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap== CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    private void craft(){
        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setInventorySlotContents(i,itemHandler.getStackInSlot(i));
        }
        Optional<CrusherRecipe> recipe = world.getRecipeManager().getRecipe(ModRecipeTypes.CRUSHER_RECIPE, inv, world);

    }

    @Override
    public void tick() {
        if(world.isRemote) {
            return;
        }
        craft();
    }
}

