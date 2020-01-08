package com.svvarg.sundry.render;

import com.svvarg.sundry.Sundry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 *
 * @author Swarg
 */
public class RenderSundryMob extends RenderLiving
{

    public RenderSundryMob(ModelBase modelBase, float p2)
    {
        super(modelBase, p2);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return new ResourceLocation(Sundry.MODID,"textures/models/sundrymob.png");        
    }

}
