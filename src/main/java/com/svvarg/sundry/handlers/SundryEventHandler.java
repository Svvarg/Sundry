package com.svvarg.sundry.handlers;

import com.svvarg.sundry.ModBlocks;
import com.svvarg.sundry.ModItems;
import com.svvarg.sundry.generation.WorldGenSundryDungeon;
import com.svvarg.sundry.generation.WorldGenSundryPlant;
import com.svvarg.sundry.items.ItemSArmor;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
/**
 *
 * @author Swarg
 */
public class SundryEventHandler implements IWorldGenerator
{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, 
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
    {
        switch (world.provider.dimensionId)
        {
            case -1: generateNether(world, random, chunkX*16,chunkZ*16);
            case  0: generateSurface(world, random, chunkX*16,chunkZ*16);
            case  1: generateEnd(world, random, chunkX*16,chunkZ*16);
        }        
    }

    private void generateNether(World world, Random random, int x, int z) {
       
    }

    private void generateSurface(World world, Random random, int x, int z) 
    {
        addOreSpawn(ModBlocks.sStone, 0, Blocks.stone, world, random, 
                x, z,//blockXPos blockZPos
                16, //maxX
                16, //maxZ
                
                //maxVeinSize  amount of ores will generate in single vein
                5+ random.nextInt(5), 
                4, //chancesToSpawn how many veins the can be in a single chunk
                20, //minY
                60  //maxY
        );
        
        //plants        
        int posX = x + random.nextInt(16);
        int posY = 40 + random.nextInt(35);
        int posZ = z + random.nextInt(16);
        new WorldGenSundryPlant().generate(world, random, posX, posY, posZ);

        //structure
        posX = x + random.nextInt(16);
        posY = 10 + random.nextInt(60);
        posZ = z + random.nextInt(16);
        new WorldGenSundryDungeon().generate(world, random, posX, posY, posZ);
    }

    private void generateEnd(World world, Random random, int x, int z) {

    }
    /**
     * 
     * @param block to generate (spawn)
     * @param metadata of spawn block
     * @param target kind of block where would be generated own block
     * @param world
     * @param random retrieving random positions within the world to spawn the Block
     * @param blockXPos
     * @param blockZPos
     * @param maxX
     * @param maxZ
     * @param maxVeinSize amount of ores will generate in single vein
     * @param chancesToSpawn how many veins the can be in a single chunk
     * @param minY
     * @param maxY 
     */
    public void addOreSpawn (Block block, int metadata, Block target, World world, 
            Random random, int blockXPos, int blockZPos, int maxX, int maxZ,int maxVeinSize,
            int chancesToSpawn,int minY, int maxY)
    {
        int maxPossY = minY +( minY- 1 );
        assert maxY > minY: "The maximum Y must be greater than the Minimum Y";
        assert maxX > 0 && maxX <=16:"addOreSpawn: The Maximim X must be greater than 0 amd less than 16";
        assert minY > 0: "addOreSpawn: The Minimum Y must be greater than 0";
        assert maxY < 256 && maxY > 0: "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
        assert maxZ > 0 && maxZ <= 16: "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
        
        int diffBtwnMinMaxY = maxY - minY;
        for (int  x = 0; x < chancesToSpawn;x++)
        {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(diffBtwnMinMaxY);
            int posZ = blockZPos + random.nextInt(maxZ);
            WorldGenMinable wgm = (new WorldGenMinable(block,metadata,maxVeinSize,target));
            //(new WorldGenMinable(block,metadata,maxVeinSize,target)).generate(world,random,posX,posY,posZ);
            wgm.generate(world,random,posX,posY,posZ);
        }
        
    }
    
    @SubscribeEvent
    public void addDrops(LivingDropsEvent event)
    {
        if (event.entity instanceof EntityZombie)
        {
            if (event.entity.worldObj.rand.nextInt(10)==0)
                event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ,
                        new ItemStack(ModItems.sboots)));
            if (event.entity.worldObj.rand.nextInt(15)==0)
                event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ,
                        new ItemStack(ModItems.shelmet)));
        }        
    }
    
    @SubscribeEvent
    public void addBlockDrops(BlockEvent.HarvestDropsEvent event)
    {
        if (event.block == Blocks.red_flower)
            event.drops.add(new ItemStack(ModItems.berry));
    }
    
    @SubscribeEvent
    public void throwEggs(PlayerInteractEvent event)
    {
        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR 
                || event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)
        {
            if (event.entityPlayer.getCurrentEquippedItem()==null)
            {
                boolean fullSuit = true;
                for (int i = 0; i < 4; i++)
                {
                    if (event.entityPlayer.getCurrentArmor(i) == null)
                    {
                        fullSuit = false;
                        return;
                    }
                    else if (!(event.entityPlayer.getCurrentArmor(i).getItem() instanceof ItemSArmor))
                    {
                        fullSuit = false;
                    }
                }
                if (fullSuit)
                {
                    event.entityPlayer.worldObj.spawnEntityInWorld(
                            new EntityEgg(event.entityPlayer.worldObj, event.entityPlayer));
                    
                }
            }
            
        }        
    }
}
