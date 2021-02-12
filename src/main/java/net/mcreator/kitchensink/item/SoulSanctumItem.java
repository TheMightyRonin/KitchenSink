
package net.mcreator.kitchensink.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.kitchensink.itemgroup.MusicItemGroup;
import net.mcreator.kitchensink.KitchenSinkModElements;

@KitchenSinkModElements.ModElement.Tag
public class SoulSanctumItem extends KitchenSinkModElements.ModElement {
	@ObjectHolder("kitchen_sink:soul_sanctum")
	public static final Item block = null;
	public SoulSanctumItem(KitchenSinkModElements instance) {
		super(instance, 144);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, KitchenSinkModElements.sounds.get(new ResourceLocation("kitchen_sink:soulsanctum")),
					new Item.Properties().group(MusicItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("soul_sanctum");
		}
	}
}
