package com.svvarg.sundry.lootchest;

import com.svvarg.sundry.lootchest.TileEntityLootChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 *
 * @author Swarg
 */
public class ContainerLootChest extends Container {

    protected TileEntityLootChest teLootChest;

    
    public ContainerLootChest(IInventory inv, TileEntityLootChest lootChest)
    {
        this.teLootChest = lootChest;
        int i;
        int j;

        for (i = 0; i < 3; ++i)
        {
            for (j = 0; j < 5; ++j)
            {
                this.addSlotToContainer(new Slot(lootChest, j + i * 5, 44 + j * 18, 17 + i * 18)
                {
                    @Override
                    public boolean isItemValid(ItemStack itemstack)
                    {
                        return false;
                    }
                });
            }
        }
        
        //player inventory
        for (i = 0; i < 3; ++i)
        {
            for (j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
        }
    }
   
   
    @Override
    public boolean canInteractWith(EntityPlayer player) 
    {
        return this.teLootChest.isUseableByPlayer(player);

    }
    
    // реакция на шрифт+клик мышкой
    public ItemStack transferStackInSlot(EntityPlayer player, int index)
    {
        /*ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < TileEntityLootChest.SLOTCOUNT)
            {
                if (!this.mergeItemStack(itemstack1, 9, 45, true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 9, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;*/
        return null;
    }

}
