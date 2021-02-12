
package net.mcreator.kitchensink.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.kitchensink.KitchenSinkModElements;

@KitchenSinkModElements.ModElement.Tag
public class GuardswordItem extends KitchenSinkModElements.ModElement {
	@ObjectHolder("kitchen_sink:guardsword")
	public static final Item block = null;
	public GuardswordItem(KitchenSinkModElements instance) {
		super(instance, 153);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(KnightmetalIngotItem.block, (int) (1)));
			}
		}, 3, -1.8f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("guardsword"));
	}
}
