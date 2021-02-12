package net.mcreator.kitchensink.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Map;

@KitchenSinkModElements.ModElement.Tag
public class VoidsummonfriendlyOnEntityTickUpdateProcedure extends KitchenSinkModElements.ModElement {
	public VoidsummonfriendlyOnEntityTickUpdateProcedure(KitchenSinkModElements instance) {
		super(instance, 113);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure VoidsummonfriendlyOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.01)) {
			if (!entity.world.isRemote)
				entity.remove();
		}
	}
}
