package com.svvarg.sundry.items;

import com.svvarg.sundry.Sundry;
import com.svvarg.sundry.entity.EntitySundryThrowable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
/**
 *
 * @author Swarg
 */
public class ItemSunThrow extends Item
{
    public ItemSunThrow(String name)
    {
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName(Sundry.MODID+"_"+name);
        setTextureName(Sundry.MODID+":"+name);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player)           
    {
        if (!player.capabilities.isCreativeMode)
        {
            --is.stackSize;
        }
        if (!world.isRemote)
        {
            world.spawnEntityInWorld(new EntitySundryThrowable(world,player));
        }
        return is;        
    }
    
}
