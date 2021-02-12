package net.mcreator.kitchensink.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Map;

@KitchenSinkModElements.ModElement.Tag
public class SummonersStaffLivingEntityIsHitWithItemProcedure extends KitchenSinkModElements.ModElement {
	public SummonersStaffLivingEntityIsHitWithItemProcedure(KitchenSinkModElements instance) {
		super(instance, 108);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SummonersStaffLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 1, (int) 1));
	}
}
