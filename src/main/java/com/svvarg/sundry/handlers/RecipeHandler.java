package com.svvarg.sundry.handlers;

import com.svvarg.sundry.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 *
 * @author Swarg
 */
public class RecipeHandler
{
    public static void RecipleHandler()
    {
        GameRegistry.addRecipe(new ItemStack(Items.apple),
                "XXX", "XXX", "XXX", 'X', Blocks.leaves);
        
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.sampaxel,
                "XXX"," Y "," Y ",'X', "ingotSam", 'Y', Items.stick));
        
        GameRegistry.addSmelting(Blocks.stone, new ItemStack(Blocks.stonebrick), 0.1F);

        ItemStack enchantedSwordItemStack = new ItemStack(Items.stone_sword);
        enchantedSwordItemStack.addEnchantment(Enchantment.sharpness, 1);
        
        GameRegistry.addShapelessRecipe(enchantedSwordItemStack, Items.flint, Items.stone_sword);        
    }
    
}
