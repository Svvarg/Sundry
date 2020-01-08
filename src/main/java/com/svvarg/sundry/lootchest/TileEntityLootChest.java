package com.svvarg.sundry.lootchest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

/**
 *
 * @author Swarg
 */
public class TileEntityLootChest extends TileEntity implements IInventory {
     public static final int SLOTCOUNT = 15;
     private ItemStack[] inventory = new ItemStack[SLOTCOUNT];
     private String customInventoryName;

    @Override
    public int getSizeInventory() {
        return SLOTCOUNT;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return ( this.inventory != null && i < this.inventory.length) ? this.inventory[i]: null;
    }

    @Override
    public ItemStack decrStackSize(int p1, int p2) {
        //дефолтное копипаст из диспенсера
        if (this.inventory[p1] != null)
        {
            ItemStack itemstack;

            if (this.inventory[p1].stackSize <= p2)
            {
                itemstack = this.inventory[p1];
                this.inventory[p1] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.inventory[p1].splitStack(p2);

                if (this.inventory[p1].stackSize == 0)
                {
                    this.inventory[p1] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
        
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
      if (this.inventory[i] != null)
        {
            ItemStack itemstack = this.inventory[i];
            this.inventory[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int p, ItemStack is) {
      this.inventory[p] = is;

        if (is != null && is.stackSize > this.getInventoryStackLimit())
        {
            is.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    public String getCustomName() 
    {
        return this.customInventoryName;
    }

    public void setCustomName(String customName) 
    {
        this.customInventoryName = customName;
    }
    
       
    @Override
    public String getInventoryName() 
    {      
      return  this.hasCustomInventoryName() ? this.customInventoryName : "container.lootCheast";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return this.customInventoryName != null && !this.customInventoryName.isEmpty();      
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;     
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {
     
    }

    @Override
    public void closeInventory() {
     
    }

    @Override
    public boolean isItemValidForSlot(int p, ItemStack iStack) {
        return true;
    }
    
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        NBTTagList nbttaglist = tag.getTagList("Items", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.inventory.length)
            {
                this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inventory.length; ++i)
        {
            if (this.inventory[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.inventory[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        tag.setTag("Items", nbttaglist);
    }
    
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) 
    {
        this.readFromNBT(packet.func_148857_g());
    }

    @Override
    public Packet getDescriptionPacket() 
    {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }
}
