package net.mcreator.kitchensink.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.kitchensink.entity.ExplodingbeeEntity;
import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Random;
import java.util.Map;

@KitchenSinkModElements.ModElement.Tag
public class StingerSaberRightClickedInAirProcedure extends KitchenSinkModElements.ModElement {
	public StingerSaberRightClickedInAirProcedure(KitchenSinkModElements instance) {
		super(instance, 15);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure StingerSaberRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure StingerSaberRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure StingerSaberRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure StingerSaberRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure StingerSaberRightClickedInAir!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			ItemStack _ist = (itemstack);
			if (_ist.attemptDamageItem((int) 25, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
		for (int index0 = 0; index0 < (int) (5); index0++) {
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new ExplodingbeeEntity.CustomEntity(ExplodingbeeEntity.entity, world.getWorld());
				entityToSpawn.setLocationAndAngles(((((new java.util.Random()).nextInt((int) 10 + 1)) - 5) + x),
						(((new java.util.Random()).nextInt((int) 3 + 1)) + (15 + y)), ((((new java.util.Random()).nextInt((int) 10 + 1)) - 5) + z),
						(float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
