package net.mcreator.kitchensink.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.kitchensink.item.VoidBlastItem;
import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Random;
import java.util.Map;

@KitchenSinkModElements.ModElement.Tag
public class RangerKnightEntityIsHurtProcedure extends KitchenSinkModElements.ModElement {
	public RangerKnightEntityIsHurtProcedure(KitchenSinkModElements instance) {
		super(instance, 106);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RangerKnightEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure RangerKnightEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (3); index0++) {
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				VoidBlastItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 2, (float) 2, (int) 5);
			}
		}
	}
}
