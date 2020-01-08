package com.svvarg.sundry.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
/**
 *
 * @author Swarg
 */
public class ItemSStone extends ItemBlock 
{
    public ItemSStone(Block block)
    {
        super(block);
        setHasSubtypes(true);
    }
     
    @Override
    public int getMetadata(int par1)
    {
        return par1;    
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        String name = "";
        switch (itemStack.getItemDamage())
        {
            case 0:
                name = "ore";
                break;
            case 1: 
                name = "wall";
                break; 
            default: System.out.println("Invalid metadata for Block SStone");
                name = "broken";
                break;                    
        }
        return getUnlocalizedName()+"."+name;
    }
    
}
