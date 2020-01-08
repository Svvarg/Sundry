package com.svvarg.sundry;

import com.svvarg.sundry.items.ItemBerry;
import com.svvarg.sundry.items.ItemKey;
import com.svvarg.sundry.items.ItemSArmor;
import com.svvarg.sundry.items.ItemSSeed;
import com.svvarg.sundry.items.ItemSamGeneric;
import com.svvarg.sundry.items.ItemSunThrow;
import com.svvarg.sundry.items.tools.ItemSamPaxel;
import com.svvarg.sundry.items.tools.ItemTitaniumPickaxe;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

/**
 *
 * @author Swarg
 */
public class ModItems
{
    //Items
    public static Item key;
    public static Item samdust;
    public static Item samingot;
    public static Item sSeed;
    public static ItemFood berry;
    public static Item sunthrow;
    
    //Tools
    public static Item titaniumpickaxe;
    public static Item sampaxel;
        
    public static ItemArmor.ArmorMaterial sarmor = EnumHelper.addArmorMaterial("sarmor", 20, new int[]{3, 7, 6, 3}, 10);
    
    //armor
    public static Item shelmet;
    public static Item schest;
    public static Item sleggings;
    public static Item sboots;
    
    public static ToolMaterial titanium = EnumHelper.addToolMaterial("titanium", 3, 1000, 9.5F, 3.5F, 10);
    
    public static void loadItems()
    {
        key = new ItemKey();
        berry = new ItemBerry(3, 0.3F, true, "Berry");
        sSeed = new ItemSSeed(ModBlocks.sPlant);
        samdust = new ItemSamGeneric("samdust");
        samingot = new ItemSamGeneric("samingot");
        sunthrow = new ItemSunThrow("sunthrow");

        titaniumpickaxe = new ItemTitaniumPickaxe(titanium, "titaniumpickaxe");
        sampaxel = new ItemSamPaxel(titanium, "sampaxel");

        //armor
        shelmet = new ItemSArmor(sarmor, 0, "shelmet");
        schest = new ItemSArmor(sarmor, 1, "schestplate");
        sleggings = new ItemSArmor(sarmor, 2, "sleggings");
        sboots = new ItemSArmor(sarmor, 3, "sboots");

        //item registry
        GameRegistry.registerItem(key, "Key");
        GameRegistry.registerItem(berry, "Berry");
        GameRegistry.registerItem(sSeed, "SSeed");
        GameRegistry.registerItem(samdust, "SamDust");
        GameRegistry.registerItem(samingot, "SamIngot");
        GameRegistry.registerItem(sunthrow, "SundryTrowable");
        
        OreDictionary.registerOre("ingotSam", new ItemStack(ModItems.samingot));
               
        //tools registry
        GameRegistry.registerItem(titaniumpickaxe, "TitaniumPickaxe");
        GameRegistry.registerItem(sampaxel, "SamsPaxel");
        
        //armor registry
        GameRegistry.registerItem(shelmet, "SHelmet");        
        GameRegistry.registerItem(schest, "SChest");
        GameRegistry.registerItem(sleggings, "SLeggings");
        GameRegistry.registerItem(sboots, "SBooths");
    }

    
}
