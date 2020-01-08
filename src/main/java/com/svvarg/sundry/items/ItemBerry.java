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
//import com.svvarg.sundry.Sundry;

import com.svvarg.sundry.Sundry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class ItemBerry extends ItemFood {
    //for setSecondPotionEffect    
    private int secondpotionId;
    private int secondpotionDuration;
    private int secondpotionAmplifier;
    private float secondpotionEffectProbability;
    
    public ItemBerry(int food, float saturation, boolean wolfFood, String name) {        
        super(food, saturation, wolfFood);
        setUnlocalizedName(Sundry.MODID+"_"+name);
        setTextureName(Sundry.MODID+":"+name);        
        setPotionEffect(Potion.moveSpeed.id,15,0,1F);
        //int id; how long sec; lvl potion;  chance that effect will take place 1f = 100% chance
        setSecondPotionEffect(Potion.digSpeed.id,15,0,1F);//relase methods
        setAlwaysEdible();       
    }
    
    protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
        super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        if (!par2World.isRemote && this.secondpotionId > 0 && 
             par2World.rand.nextFloat()< this.secondpotionEffectProbability){
            par3EntityPlayer.addPotionEffect(new PotionEffect(this.secondpotionId, this.secondpotionDuration*20,this.secondpotionAmplifier));
        }
    }
    // for setSecondPotionEffect
    public ItemFood setSecondPotionEffect(int par1, int par2, int par3, float par4){
        this.secondpotionId = par1;
        this.secondpotionDuration = par2;
        this.secondpotionAmplifier = par3;
        this.secondpotionEffectProbability = par4;
        return this;
    }
    
    
}
