
package net.mcreator.kitchensink.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.kitchensink.KitchenSinkModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@KitchenSinkModElements.ModElement.Tag
public class SteampackItem extends KitchenSinkModElements.ModElement {
	@ObjectHolder("kitchen_sink:steampack_helmet")
	public static final Item helmet = null;
	@ObjectHolder("kitchen_sink:steampack_chestplate")
	public static final Item body = null;
	@ObjectHolder("kitchen_sink:steampack_leggings")
	public static final Item legs = null;
	@ObjectHolder("kitchen_sink:steampack_boots")
	public static final Item boots = null;
	public SteampackItem(KitchenSinkModElements instance) {
		super(instance, 162);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 75;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 2, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "steampack";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedBody = new Modelsteampack3().Body;
				armorModel.bipedLeftArm = new Modelsteampack3().arms;
				armorModel.bipedRightArm = new Modelsteampack3().arms;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "kitchen_sink:textures/steampack3.png";
			}
		}.setRegistryName("steampack_chestplate"));
	}
	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelsteampack3 extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer arms;
		public Modelsteampack3() {
			textureWidth = 32;
			textureHeight = 32;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.setTextureOffset(16, 4).addBox(-1.0F, 3.0F, 2.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			Body.setTextureOffset(0, 15).addBox(-4.5F, 0.0F, 2.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			Body.setTextureOffset(12, 0).addBox(1.5F, 0.0F, 2.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			Body.setTextureOffset(12, 12).addBox(-5.0F, 1.0F, 2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);
			Body.setTextureOffset(0, 0).addBox(1.0F, 1.0F, 2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);
			arms = new ModelRenderer(this);
			arms.setRotationPoint(3.0F, 1.0F, 4.0F);
			Body.addChild(arms);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
