package com.svvarg.sundry.blocks;

import com.svvarg.sundry.ModItems;
import com.svvarg.sundry.Sundry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

/**
 *
 * @author Swarg
 */
public class BlockSStone extends Block {
    String name = "sstone";
    
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    
    public BlockSStone() {
        super(Material.rock);
        setBlockName(Sundry.MODID+"_"+name);
        //setBlockTextureName(Sundry.MODID+":"+name); for use block without meta
        setCreativeTab(CreativeTabs.tabMisc);
        setHardness(2f);//-1.0Fдля бедрока - не ломаемый); как долго ломать
        setResistance(5f);//6000000.0F);
        setStepSound(soundTypeStone);
        setHarvestLevel("pickaxe",2);        
        
        //this.setBlockBounds(0, 0, 0, 0.5F, 1F, 0.25F); задание формы для всех блоков
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        if ( meta == 1 )
        {
            setBlockBounds(0F,0F,0F,1F,0.5F,1F);
        } else if(  meta == 0)
        {
            setBlockBounds(0F,0F,0F,1F,1F,1F);
        }
    }
    
    @Override
    public Item getItemDropped(int meta, Random rand,int fortune){
        return ModItems.samdust;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        icons = new IIcon[3];
        for (int i = 0; i < icons.length; i++) 
        {
            icons[i] = par1IconRegister.registerIcon(Sundry.MODID+":"+name+i);            
        }    
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        switch(par2)
        {
            case 0: 
                return icons[0];
            case 1:
                if (ForgeDirection.getOrientation(par1)==ForgeDirection.UP 
                        ||ForgeDirection.getOrientation(par1)== ForgeDirection.DOWN)
                    return icons[2];
                else
                    return icons[1];
            default:
                return icons[0];
                //System.out.println("Problem with getting the icon for BlockSStone");
                //return null;                
        }            
    }
    
    @SuppressWarnings({"unckecked","rawtypes"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTab, List par3List)
    {
        for (int var4 = 0; var4 < 2; ++var4) {
            par3List.add(new ItemStack(par1,1,var4));
            
        }
    }

}
