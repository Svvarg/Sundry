package com.svvarg.sundry.items;

import com.svvarg.sundry.Sundry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

/**
 *
 * @author Swarg
 */
public class ItemSSeed extends Item implements IPlantable
{
    private Block plant;
    private String name = "sseed";
    
    public ItemSSeed(Block plant)            
    {
        this.plant = plant;
        setUnlocalizedName (Sundry.MODID+"_"+name);
        setTextureName (Sundry.MODID +":"+name);
        setCreativeTab(CreativeTabs.tabMaterials);
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) 
    {
        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z) 
    {
        return plant;        
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) 
    {
        return 0;        
    }
    
    public boolean onItemUse(ItemStack iStack, EntityPlayer player, World world,
            int p4, int p5, int p6, int p7, float p8, float p9, float p10)
    {
        if (p7 != 1)
            return false;
        else if (player.canPlayerEdit(p4,p5,p6,p7,iStack)
                && player.canPlayerEdit(p4, p5+1, p6, p7, iStack))
        {
            if (world.getBlock(p4, p5+1, p6)== Blocks.dirt
                    || world.getBlock(p4, p5, p6)==Blocks.grass)
            {
                if ( world.isAirBlock(p4,p5+1,p6) )
                {
                    world.setBlock(p4, p5+1, p6, this.plant);
                    --iStack.stackSize;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
}
