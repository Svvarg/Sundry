package com.svvarg.sundry;


import com.svvarg.sundry.tileentities.TileEntitySundry;
import com.svvarg.sundry.handlers.SundryEventHandler;
import com.svvarg.sundry.handlers.RecipeHandler;
import com.svvarg.sundry.proxies.CommonProxySundry;
import com.svvarg.sundry.lootchest.GuiLootChestHandler;
import com.svvarg.sundry.lootchest.TileEntityLootChest;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;


@Mod(modid = Sundry.MODID, version = Sundry.VERSION)
public class Sundry {
    
    @Instance(Sundry.MODID)//"Sundry")
    public static Sundry instance;

    public static final String MODID = "sundry";
    public static final String VERSION = "0.2";
    
    SundryEventHandler handler = new SundryEventHandler();

    @SidedProxy(clientSide = "com.svvarg.sundry.proxies.ClientProxySundry",
            serverSide = "com.svvarg.sundry.proxies.CommonProxySundry")
    public static CommonProxySundry proxy;   
    

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
        //Sundry.instance = this;
        
        proxy.registerRendering();
        
        ModBlocks.loadBlocks();
        
        GameRegistry.registerTileEntity(TileEntitySundry.class, "TE_sundryTE");
        GameRegistry.registerTileEntity(TileEntityLootChest.class, "TELootChest");

        ModItems.loadItems();
       
        proxy.registerItemRenders();
        
        ModEntities.loadEntities();        
        
        GameRegistry.registerWorldGenerator(handler,0);        

        MinecraftForge.EVENT_BUS.register(handler);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        
        RecipeHandler.RecipleHandler();

        //Sundry.instance = this;//for GUI opening
        NetworkRegistry.INSTANCE.registerGuiHandler(Sundry.instance, new GuiLootChestHandler());        
    }
    
}
