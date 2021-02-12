package net.mcreator.kitchensink.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Map;

@KitchenSinkModElements.ModElement.Tag
public class MeleeKnightOnInitialEntitySpawnProcedure extends KitchenSinkModElements.ModElement {
	public MeleeKnightOnInitialEntitySpawnProcedure(KitchenSinkModElements instance) {
		super(instance, 145);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure MeleeKnightOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 1, (int) 0.5, (true), (false)));
	}
}
