package com.svvarg.sundry;

import com.svvarg.sundry.blocks.BlockSPlant;
import com.svvarg.sundry.blocks.BlockSStone;
import com.svvarg.sundry.blocks.BlockSTE;
import com.svvarg.sundry.items.ItemSStone;
import com.svvarg.sundry.lootchest.BlockLootChestTE;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 *
 * @author Swarg
 */
public class ModBlocks
{        
    public static Block sStone;
    public static Block sPlant;    
    public static Block sTE;
    public static Block lootChestTE;

    public static void loadBlocks()
    {        
        sStone = new BlockSStone();
        sPlant = new BlockSPlant();
        sTE = new BlockSTE();
        lootChestTE = new BlockLootChestTE();
        
        GameRegistry.registerBlock(sStone, ItemSStone.class, "SStone");//for metadata
        GameRegistry.registerBlock(sPlant,"Sundry Plant");//reg method as without meta
        GameRegistry.registerBlock(sTE, "SundryTE");
        GameRegistry.registerBlock(lootChestTE, "LootChestTEBlock");
    }
}
