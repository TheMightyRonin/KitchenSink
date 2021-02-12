package net.mcreator.kitchensink.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.kitchensink.block.CopperBlockBlock;
import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Map;

@KitchenSinkModElements.ModElement.Tag
public class ArcaneMapItemInHandTickProcedure extends KitchenSinkModElements.ModElement {
	public ArcaneMapItemInHandTickProcedure(KitchenSinkModElements instance) {
		super(instance, 59);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ArcaneMapItemInHandTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ArcaneMapItemInHandTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ArcaneMapItemInHandTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ArcaneMapItemInHandTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ArcaneMapItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((new ItemStack(Blocks.AIR, (int) (1))
				.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem())) {
			if ((Math.random() < 0.00005)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("The map says a gold bar should be nearby..."), (true));
				}
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (x + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), y,
							(z + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), new ItemStack(Items.GOLD_INGOT, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if ((Math.random() < 0.00003)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("The map says an iron bar should be nearby..."), (true));
				}
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (x + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), y,
							(z + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), new ItemStack(Items.IRON_INGOT, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if ((Math.random() < 0.00001)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("The map says a name tag should be nearby..."), (true));
				}
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (x + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), y,
							(z + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), new ItemStack(Items.NAME_TAG, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if ((Math.random() < 0.000005)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("The map says a diamond should be nearby..."), (true));
				}
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (x + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), y,
							(z + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), new ItemStack(Items.DIAMOND, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if ((Math.random() < 0.000003)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("The map says a saddle should be nearby..."), (true));
				}
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (x + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), y,
							(z + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), new ItemStack(Items.SADDLE, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if ((Math.random() < 0.000001)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("The map says a large cache should be nearby..."), (true));
				}
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (x + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), y,
							(z + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), new ItemStack(Items.SADDLE, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (x + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), y,
							(z + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), new ItemStack(Items.DIAMOND, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				for (int index0 = 0; index0 < (int) (3); index0++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (x + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), y,
								(z + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), new ItemStack(Items.IRON_INGOT, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				for (int index1 = 0; index1 < (int) (3); index1++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (x + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), y,
								(z + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), new ItemStack(Items.GOLD_INGOT, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (x + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), y,
							(z + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), new ItemStack(Items.NAME_TAG, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (x + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), y,
							(z + (((new java.util.Random()).nextInt((int) 10 + 1)) - 5)), new ItemStack(CopperBlockBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
