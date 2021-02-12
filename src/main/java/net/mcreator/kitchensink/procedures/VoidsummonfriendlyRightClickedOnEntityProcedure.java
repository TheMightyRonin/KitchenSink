package net.mcreator.kitchensink.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Map;

@KitchenSinkModElements.ModElement.Tag
public class VoidsummonfriendlyRightClickedOnEntityProcedure extends KitchenSinkModElements.ModElement {
	public VoidsummonfriendlyRightClickedOnEntityProcedure(KitchenSinkModElements instance) {
		super(instance, 170);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure VoidsummonfriendlyRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!entity.world.isRemote)
			entity.remove();
	}
}
