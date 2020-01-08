package com.svvarg.sundry.items;

/**
 *
 * @author Swarg
 */
import com.svvarg.sundry.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import com.svvarg.sundry.Sundry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemSArmor extends ItemArmor {

    public ItemSArmor(ArmorMaterial material, int armorType, String name) {
        super(material, 0, armorType);
        setUnlocalizedName(Sundry.MODID + "_" + name);
        setTextureName(Sundry.MODID + ":" + name);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == ModItems.shelmet || stack.getItem() == ModItems.schest
                || stack.getItem() == ModItems.sboots) {
            return Sundry.MODID + ":models/armor/sarmor1.png";
        } else if (stack.getItem() == ModItems.sleggings) {
            return Sundry.MODID + ":models/armor/sarmor2.png";
        } else {
            System.out.println("Invalid Item");
            return null;
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (itemStack.getItem() == ModItems.shelmet) {
            if (player.isInWater()) {
                player.setAir(20);
            }
        }
    }

}
