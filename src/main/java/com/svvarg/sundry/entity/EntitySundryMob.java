package com.svvarg.sundry.entity;

import com.svvarg.sundry.ModItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 *
 * @author Swarg
 */
public class EntitySundryMob extends EntityMob
{

    public EntitySundryMob(World world)
    {
        super(world);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this,EntityPlayer.class,1D,false));
        this.tasks.addTask(3, new EntityAIWander(this,1D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8F));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityVillager.class, 8F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this,true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,EntityPlayer.class,0,true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,EntityVillager.class,0,true));
        
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30D);        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(60D);
    }
    
    protected Item getDropItem()
    {
        return ModItems.samdust;
    }
    
    protected void dropRareDrop(int p1)
    {
        switch (this.rand.nextInt(2))
        {
            case 0: 
                this.dropItem(ModItems.titaniumpickaxe, 1);
                break;
            case 1: 
                //this.dropItem(Item.getItemFromBlock(Sundry.sTE),1);
                this.dropItem(ModItems.berry, 1);
        }        
    }
    
    
    
    /*for extends Entity
    @Override
    protected void entityInit()
    {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {

    }
    */
}
