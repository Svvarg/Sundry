package com.svvarg.sundry;

import com.svvarg.sundry.entity.EntitySundryMob;
import com.svvarg.sundry.entity.EntitySundryThrowable;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.world.biome.BiomeGenBase;

/**
 *
 * @author Swarg
 */
public class ModEntities
{
    
    public static void loadEntities()
    {
        EntityRegistry.registerModEntity(EntitySundryMob.class,"sundrymob",0,Sundry.instance,80,3,true);
        EntityRegistry.registerModEntity(EntitySundryThrowable.class,"sundrythrow",1,Sundry.instance,80,3,true);

        EntityRegistry.addSpawn(EntitySundryMob.class, 10, 1, 3, EnumCreatureType.monster, BiomeGenBase.forest);
        RemoveCreeperSpawn();
        
        registerEntityEgg(EntitySundryMob.class, 0xd8bb9d, 0xa63c1a);

    }
    
    static int startEntityId = 300;
    
    @SuppressWarnings("uncheked")
    public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor,
            int secondaryColor)
    {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id,entity);
        EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id,primaryColor,secondaryColor));
    }
    
    public static int getUniqueEntityId()
    {
        do 
        {
            startEntityId++;            
        }
        while (EntityList.getStringFromID(startEntityId) != null);
        return startEntityId;
    }
    
    public static void RemoveCreeperSpawn()
    {        
        for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++)
        {
            if (BiomeGenBase.getBiomeGenArray()[i] != null)
            {
                EntityRegistry.removeSpawn(EntityCreeper.class, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
            }            
        }
    }
    
    
}
