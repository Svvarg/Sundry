package com.svvarg.sundry.blocks;

import com.svvarg.sundry.Sundry;
import com.svvarg.sundry.tileentities.TileEntitySundry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 *
 * @author Swarg
 */
public class BlockSTE extends BlockContainer {
    private String name = "ste";
    private IIcon[] icons;

    public BlockSTE()
    {
        super(Material.rock);
        setBlockName(Sundry.MODID + "_"+name);
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(2F);
        setResistance(5F);
        setStepSound(soundTypeStone);
        setHarvestLevel("pichaxe",2);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p1IconRegister)
    {
        icons = new IIcon[10];
        for (int i = 0; i < icons.length; i++) 
        {
            icons[i] = p1IconRegister.registerIcon(Sundry.MODID+":"+"ste"+i);
        }
    }
    
    @Override 
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p1, int p2)
    {
        return icons[p2];
    }
    
    @Override
    public TileEntity createNewTileEntity(World w, int p2)
    {
        return new TileEntitySundry();
    }
    
    @Override
    public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer player,
            int side, float hitX, float hitY, float hitZ)
    {
        TileEntity entity = w.getTileEntity(x,y,z);
        if (entity  != null && entity instanceof TileEntitySundry)
        {
            TileEntitySundry sE = (TileEntitySundry) entity;
            if (player.isSneaking() && !w.isRemote)
                sE.editCounter();
            return true;
        }
        return false;
    }
}
