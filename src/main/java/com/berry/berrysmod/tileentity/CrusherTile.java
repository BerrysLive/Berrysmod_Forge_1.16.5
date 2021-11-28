//package com.berry.berrysmod.tileentity;
//
//import com.berry.berrysmod.item.ModItems;
//import net.minecraft.block.BlockState;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.tileentity.TileEntityType;
//import net.minecraft.util.Direction;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.items.CapabilityItemHandler;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemStackHandler;
//
//import javax.annotation.Nonnull;
//import javax.annotation.Nullable;
//
//public class CrusherTile extends TileEntity {
//    private final ItemStackHandler itemHandler = createHandler();
//
//    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
//
//    public CrusherTile(TileEntityType<?> tileEntityTypeIn) {
//        super(tileEntityTypeIn);
//    }
//
//    public CrusherTile() {
//        this(ModTileEntities.CRUSHERTILE.get());
//    }
//
//    @Override
//    public void read(BlockState state, CompoundNBT nbt) {
//        itemHandler.deserializeNBT(nbt.getCompound("inv"));
//        super.read(state, nbt);
//    }
//
//    @Override
//    public CompoundNBT write(CompoundNBT compound) {
//        compound.put("inv", itemHandler.serializeNBT());
//        return super.write(compound);
//    }
//
//    private ItemStackHandler createHandler() {
//        return new ItemStackHandler(2) {
//            @Override
//            protected void onContentsChanged(int slot) {
//                markDirty();
//            }
//
//            @Override
//            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
//                switch (slot) {
//                    case 0:
//                        return stack.getItem() == Items.;
//                    case 1:
//                        return stack.getItem() == ModItems..get() || stack.getItem() == ModItems..get();
//                    default:
//                        return false;
//                }
//            }
//        };
//    }
//}