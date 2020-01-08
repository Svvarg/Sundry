/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svvarg.sundry.items;
/**
 *
 * @author Swarg
 */
import com.svvarg.sundry.Sundry;
import com.svvarg.sundry.Sundry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSamGeneric extends Item {
    public ItemSamGeneric(String name){
        setUnlocalizedName(Sundry.MODID+"_"+name);
        setTextureName(Sundry.MODID+":"+name);
        setCreativeTab(CreativeTabs.tabMisc);
    }
                    
}
