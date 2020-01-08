//Schematic to java Structure by jajo_11 | inspired by "MITHION'S .SCHEMATIC TO JAVA CONVERTINGTOOL"
package com.svvarg.sundry.generation;

import com.svvarg.sundry.ModBlocks;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSundryDungeon extends WorldGenerator
{

    protected Block[] GetValidSpawnBlocks()
    {
        return new Block[]
        {
            Blocks.dirt,
            Blocks.gravel,
            Blocks.stone,
            Blocks.grass,
        };
    }

    public boolean LocationIsValidSpawn(World world, int x, int y, int z)
    {

        Block checkBlock = world.getBlock(x, y, z);

        for (Block block : GetValidSpawnBlocks())
        {
            if (checkBlock == block)
            {
                return true;
            }
        }
        return false;
    }

    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        int i = rand.nextInt(4);

        if (i == 0)//chanse        
            generate_r0(world, rand, x, y, z);        

        return true;
    }

    public boolean generate_r0(World world, Random rand, int x, int y, int z)
    {
        if (!LocationIsValidSpawn(world, x, y, z)
                || !LocationIsValidSpawn(world, x + 6, y, z)
                || !LocationIsValidSpawn(world, x + 6, y, z + 6)
                || !LocationIsValidSpawn(world, x, y, z + 6))
        {
            return false;
        }

        world.setBlock(x + 0, y + 0, z + 0, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 1, y + 0, z + 0, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 2, y + 0, z + 0, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 3, y + 0, z + 0, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 4, y + 0, z + 0, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 5, y + 0, z + 0, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 6, y + 0, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 0, z + 1, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 1, y + 0, z + 1, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 0, z + 1, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 0, z + 1, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 4, y + 0, z + 1, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 5, y + 0, z + 1, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 6, y + 0, z + 1, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 0, z + 2, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 1, y + 0, z + 2, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 2, y + 0, z + 2, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 3, y + 0, z + 2, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 4, y + 0, z + 2, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 5, y + 0, z + 2, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 6, y + 0, z + 2, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 0, z + 3, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 1, y + 0, z + 3, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 2, y + 0, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 0, z + 3, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 4, y + 0, z + 3, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 5, y + 0, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 0, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 0, z + 4, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 1, y + 0, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 0, z + 4, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 3, y + 0, z + 4, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 4, y + 0, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 5, y + 0, z + 4, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 6, y + 0, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 0, z + 5, Blocks.stonebrick, 1, 3);        
        world.setBlock(x + 2, y + 0, z + 5, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 3, y + 0, z + 5, Blocks.dropper, 1, 3);
        world.setBlock(x + 4, y + 0, z + 5, Blocks.stonebrick, 1, 3);        
        world.setBlock(x + 6, y + 0, z + 5, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 0, z + 6, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 1, y + 0, z + 6, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 2, y + 0, z + 6, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 3, y + 0, z + 6, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 4, y + 0, z + 6, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 5, y + 0, z + 6, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 6, y + 0, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 1, z + 0, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 1, y + 1, z + 0, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 2, y + 1, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 1, z + 0, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 1, z + 0, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 5, y + 1, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 1, z + 0, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 0, y + 1, z + 1, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 1, y + 1, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 2, y + 1, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 1, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 1, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 1, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 6, y + 1, z + 1, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 0, y + 1, z + 2, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 1, y + 1, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 2, y + 1, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 1, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 1, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 1, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 6, y + 1, z + 2, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 0, y + 1, z + 3, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 1, y + 1, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 2, y + 1, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 1, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 1, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 1, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 6, y + 1, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 1, z + 4, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 1, y + 1, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 2, y + 1, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 1, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 1, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 1, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 6, y + 1, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 1, z + 5, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 1, y + 1, z + 5, ModBlocks.sStone, 8, 3);
        world.setBlock(x + 2, y + 1, z + 5, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 1, z + 5, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 1, z + 5, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 1, z + 5, ModBlocks.sStone, 8, 3);
        world.setBlock(x + 6, y + 1, z + 5, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 1, z + 6, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 1, y + 1, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 1, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 1, z + 6, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 4, y + 1, z + 6, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 5, y + 1, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 1, z + 6, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 0, y + 2, z + 0, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 1, y + 2, z + 0, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 2, y + 2, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 2, z + 0, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 2, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 5, y + 2, z + 0, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 6, y + 2, z + 0, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 0, y + 2, z + 1, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 1, y + 2, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 2, y + 2, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 2, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 2, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 2, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 6, y + 2, z + 1, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 0, y + 2, z + 2, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 1, y + 2, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 2, y + 2, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 2, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 2, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 2, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 6, y + 2, z + 2, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 0, y + 2, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 1, y + 2, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 2, y + 2, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 2, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 2, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 2, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 6, y + 2, z + 3, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 0, y + 2, z + 4, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 1, y + 2, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 2, y + 2, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 2, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 2, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 2, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 6, y + 2, z + 4, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 0, y + 2, z + 5, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 1, y + 2, z + 5, ModBlocks.sStone, 8, 3);
        world.setBlock(x + 2, y + 2, z + 5, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 2, z + 5, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 2, z + 5, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 2, z + 5, ModBlocks.sStone, 8, 3);
        world.setBlock(x + 6, y + 2, z + 5, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 0, y + 2, z + 6, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 1, y + 2, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 2, z + 6, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 3, y + 2, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 4, y + 2, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 5, y + 2, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 2, z + 6, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 0, y + 3, z + 0, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 1, y + 3, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 3, z + 0, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 3, y + 3, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 4, y + 3, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 5, y + 3, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 3, z + 0, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 0, y + 3, z + 1, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 1, y + 3, z + 1, Blocks.web, 0, 3);
        world.setBlock(x + 2, y + 3, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 3, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 3, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 3, z + 1, Blocks.air, 0, 3);
        world.setBlock(x + 6, y + 3, z + 1, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 0, y + 3, z + 2, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 1, y + 3, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 2, y + 3, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 3, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 3, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 3, z + 2, Blocks.air, 0, 3);
        world.setBlock(x + 6, y + 3, z + 2, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 3, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 1, y + 3, z + 3, Blocks.stone_stairs, 5, 3);
        world.setBlock(x + 2, y + 3, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 3, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 3, z + 3, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 3, z + 3, Blocks.stone_stairs, 4, 3);
        world.setBlock(x + 6, y + 3, z + 3, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 0, y + 3, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 1, y + 3, z + 4, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 2, y + 3, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 3, y + 3, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 4, y + 3, z + 4, Blocks.air, 0, 3);
        world.setBlock(x + 5, y + 3, z + 4, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 6, y + 3, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 3, z + 5, Blocks.stonebrick, 1, 3);        
        world.setBlock(x + 2, y + 3, z + 5, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 3, y + 3, z + 5, Blocks.stone_stairs, 6, 3);
        world.setBlock(x + 4, y + 3, z + 5, Blocks.stonebrick, 3, 3);        
        world.setBlock(x + 6, y + 3, z + 5, Blocks.stonebrick, 2, 3);
        world.setBlock(x + 0, y + 3, z + 6, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 1, y + 3, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 3, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 3, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 4, y + 3, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 5, y + 3, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 3, z + 6, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 0, y + 4, z + 0, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 1, y + 4, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 4, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 4, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 4, y + 4, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 5, y + 4, z + 0, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 4, z + 0, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 0, y + 4, z + 1, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 1, y + 4, z + 1, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 4, z + 1, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 4, z + 1, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 4, y + 4, z + 1, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 5, y + 4, z + 1, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 4, z + 1, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 4, z + 2, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 1, y + 4, z + 2, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 4, z + 2, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 3, y + 4, z + 2, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 4, y + 4, z + 2, Blocks.stonebrick, 1, 3);
        world.setBlock(x + 5, y + 4, z + 2, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 4, z + 2, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 4, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 1, y + 4, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 4, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 4, z + 3, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 4, y + 4, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 5, y + 4, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 4, z + 3, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 4, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 1, y + 4, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 4, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 4, z + 4, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 4, y + 4, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 5, y + 4, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 4, z + 4, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 4, z + 5, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 1, y + 4, z + 5, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 4, z + 5, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 4, z + 5, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 4, y + 4, z + 5, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 5, y + 4, z + 5, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 4, z + 5, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 0, y + 4, z + 6, Blocks.stonebrick, 3, 3);
        world.setBlock(x + 1, y + 4, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 2, y + 4, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 3, y + 4, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 4, y + 4, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 5, y + 4, z + 6, Blocks.stonebrick, 0, 3);
        world.setBlock(x + 6, y + 4, z + 6, Blocks.stonebrick, 3, 3);
        
        //world.setBlock(x + 3, y + 0, z + 5, Blocks.dropper, 1, 3);
        int x1 = x+3;
        int z1 = z+4;
        world.setBlock(x1, y, z1, Blocks.mob_spawner);
        TileEntityMobSpawner spawner = (TileEntityMobSpawner)world.getTileEntity(x1, y, z1);
        if ( spawner !=null )
        {
            spawner.func_145881_a().setEntityName("Skeleton");
        }
        else
        {
            System.out.println("Failed to fetch mob spawner entity at "+(x1)+" "+y+" "+z1);
        }
        
        EntityZombie entity = new EntityZombie(world);
        entity.setPosition(x1, y+2, z1);
        world.spawnEntityInWorld(entity);        
        return true;

    }

}
