package net.mcreator.kitchensink.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.kitchensink.item.Token1Item;
import net.mcreator.kitchensink.KitchenSinkModVariables;
import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Map;

@KitchenSinkModElements.ModElement.Tag
public class Token1ItemInInventoryTickProcedure extends KitchenSinkModElements.ModElement {
	public Token1ItemInInventoryTickProcedure(KitchenSinkModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Token1ItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(Token1Item.block, (int) (1));
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
		}
		{
			double _setval = (double) (((entity.getCapability(KitchenSinkModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new KitchenSinkModVariables.PlayerVariables())).playerbal) + 1);
			entity.getCapability(KitchenSinkModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.playerbal = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
