package com.svvarg.sundry.lootchest;

import com.svvarg.sundry.lootchest.TileEntityLootChest;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
/**
 *
 * @author Swarg
 */
public class GuiLootChestHandler implements IGuiHandler {
    public static final int GUIIDLOOTCHEST = 0;
    
   /**
   * Вызов контейнера при его открытии.
   */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(x, y, z);
        if ( ID == GUIIDLOOTCHEST && te instanceof TileEntityLootChest)
            return new ContainerLootChest(player.inventory, (TileEntityLootChest) te);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(x, y, z);
        if ( ID == GUIIDLOOTCHEST && te instanceof TileEntityLootChest)
            return new GuiLootChest(player.inventory, (TileEntityLootChest) te);
        return null;
    }
    
    
    
}
