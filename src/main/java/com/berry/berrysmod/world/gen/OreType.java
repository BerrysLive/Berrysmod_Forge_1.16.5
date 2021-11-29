package com.berry.berrysmod.world.gen;

import com.berry.berrysmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

    COPPER(Lazy.of(ModBlocks.COPPER_ORE),8,30,60),
    TIN(Lazy.of(ModBlocks.TIN_ORE),8,25,50),
    LEAD(Lazy.of(ModBlocks.LEAD_ORE),8,25,40);


    private final Lazy<Block> block;
    private final int maxveinSize;
    private final int minHeight;
    private final int maxHeight;

    OreType(Lazy<Block> block, int maxveinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxveinSize = maxveinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxveinSize() {
        return maxveinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
    public static com.berry.berrysmod.world.gen.OreType get(Block block){
        for(OreType ore: values()){
            if(block==ore.block){
                return ore;
            }
        }
        return null;
    }
}
