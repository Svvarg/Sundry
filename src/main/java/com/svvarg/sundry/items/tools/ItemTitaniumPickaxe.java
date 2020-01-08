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
import com.svvarg.sundry.Sundry;
import java.util.Set;
import net.minecraft.item.ItemPickaxe;


public class ItemTitaniumPickaxe extends ItemPickaxe{

    public ItemTitaniumPickaxe(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(Sundry.MODID+"_"+name);
        setTextureName(Sundry.MODID+":"+name);
    }

    
}
