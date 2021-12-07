package com.berry.berrysmod.data.recipes;

import com.berry.berrysmod.block.ModBlocks;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class CrusherRecipe implements ICrusherRecipe {

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public CrusherRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        //Checks for correct focus (Glass Pane in Tutorial)
        return recipeItems.get(0).test(inv.getStackInSlot(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return output;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output.copy();
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.CRUSHER.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.CRUSHER_SERIALIZER.get();
    }
   public static class CrusherRecipeType implements IRecipeType<CrusherRecipe>{
       @Override
       public String toString() {
           return CrusherRecipe.TYPE_ID.toString();
       }
   }
   public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements  IRecipeSerializer<CrusherRecipe>{

       @Override
       public CrusherRecipe read(ResourceLocation recipeId, JsonObject json) {
           ItemStack output = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json,"output"));
           int count = JSONUtils.getInt(json,"count");
           output.setCount(count);
           JsonArray ingredients = JSONUtils.getJsonArray(json,"ingredients");
           //p_191197_0_ Represents how many ingredients are in the craft to get the output (result)
           NonNullList<Ingredient> inputs = NonNullList.withSize(1,Ingredient.EMPTY);

           for (int i = 0; i < inputs.size(); i++) {
               inputs.set(i, Ingredient.deserialize((ingredients.get(i))));
           }
           return new CrusherRecipe(recipeId,output,inputs);
       }

       @Nullable
       @Override
       public CrusherRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
           //p_191197_0_ Represents how many ingredients are in the craft to get the output (result)
           NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readInt(),Ingredient.EMPTY);
           for (int i = 0; i < inputs.size(); i++) {
               inputs.set(i,Ingredient.read(buffer));
           }
           ItemStack output = buffer.readItemStack();
           int count = buffer.readInt();
           output.setCount(count);
           return new CrusherRecipe(recipeId,output,inputs);
       }

       @Override
       public void write(PacketBuffer buffer, CrusherRecipe recipe) {
           buffer.writeInt(recipe.getIngredients().size());
           for (Ingredient ing : recipe.getIngredients()) {
               ing.write(buffer);
           }
           buffer.writeItemStack(recipe.getRecipeOutput(),false);
           buffer.writeInt(recipe.getRecipeOutput().getCount());
       }
   }
}
