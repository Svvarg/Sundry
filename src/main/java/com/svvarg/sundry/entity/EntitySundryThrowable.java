package com.svvarg.sundry.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 *
 * @author Swarg
 */
public class EntitySundryThrowable extends EntityThrowable
{

    public EntitySundryThrowable(World world)
    {
        super(world);
    }

    public EntitySundryThrowable(World world, EntityLivingBase entityLivingBase)
    {
        super(world, entityLivingBase);
    }

    public EntitySundryThrowable(World world, double p1, double p2, double p3)
    {
        super(world, p1, p2, p3);
    }

    @Override
    protected void onImpact(MovingObjectPosition position)
    {
        if (!this.worldObj.isRemote)
        {
            worldObj.newExplosion(this, position.blockX , position.blockY, position.blockZ, 3F,true,true);
            this.setDead();
        }

    }
    
    protected float getGravityVelocity()
    {
        return 0.07F;
    }

    protected float func_70182_d()
    {
        return 0.7F;
    }
    
    protected float func_70183_g()
    {
        return -20F;
    }
}
