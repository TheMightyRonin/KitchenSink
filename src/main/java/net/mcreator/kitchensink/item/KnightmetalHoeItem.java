
package net.mcreator.kitchensink.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.kitchensink.KitchenSinkModElements;

@KitchenSinkModElements.ModElement.Tag
public class KnightmetalHoeItem extends KitchenSinkModElements.ModElement {
	@ObjectHolder("kitchen_sink:knightmetal_hoe")
	public static final Item block = null;
	public KnightmetalHoeItem(KitchenSinkModElements instance) {
		super(instance, 87);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(KnightmetalIngotItem.block, (int) (1)));
			}
		}, 1f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("knightmetal_hoe"));
	}
}
