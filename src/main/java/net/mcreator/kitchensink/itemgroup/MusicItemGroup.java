
package net.mcreator.kitchensink.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.kitchensink.KitchenSinkModElements;

@KitchenSinkModElements.ModElement.Tag
public class MusicItemGroup extends KitchenSinkModElements.ModElement {
	public MusicItemGroup(KitchenSinkModElements instance) {
		super(instance, 143);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmusic") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.MUSIC_DISC_CHIRP, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
