/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svvarg.sundry.items.tools;

/**
 *
 * @author Swarg
 */
import java.util.Set;
import com.google.common.collect.Sets;
import com.svvarg.sundry.Sundry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;

public class ItemSamPaxel extends ItemTool {
    
    private static Set blocks = Sets.newHashSet(new Block[] {Blocks.cobblestone,Blocks.double_stone_slab,
    Blocks.stone, Blocks.log, Blocks.planks, Blocks.log2});
    
    public ItemSamPaxel(ToolMaterial material,String name){
        super (3, material, blocks);
        setUnlocalizedName(Sundry.MODID+"_"+name);
        setTextureName(Sundry.MODID+":"+name);
    }
    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase,
            EntityLivingBase par3EntityLivingBase){
        par1ItemStack.damageItem(1,par3EntityLivingBase);
        return true;
    }
            
    
}
