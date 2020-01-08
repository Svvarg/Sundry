package com.svvarg.sundry.proxies;

import com.svvarg.sundry.ModItems;
import com.svvarg.sundry.entity.EntitySundryMob;
import com.svvarg.sundry.entity.EntitySundryThrowable;
import com.svvarg.sundry.render.ModelSundryMob;
import com.svvarg.sundry.render.RenderSundryMob;
import com.svvarg.sundry.Sundry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;

/**
 *
 * @author Swarg
 */
public class ClientProxySundry extends CommonProxySundry
{
    @Override
    public void registerRendering()
    {     
        RenderingRegistry.registerEntityRenderingHandler(EntitySundryMob.class, 
                new RenderSundryMob(new ModelSundryMob(),0.5f));
    }
    
    @Override
    public void registerItemRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntitySundryThrowable.class, 
                new RenderSnowball(ModItems.sunthrow));
    }
}
