
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
public class VoidJetsItem extends KitchenSinkModElements.ModElement {
	@ObjectHolder("kitchen_sink:void_jets_helmet")
	public static final Item helmet = null;
	@ObjectHolder("kitchen_sink:void_jets_chestplate")
	public static final Item body = null;
	@ObjectHolder("kitchen_sink:void_jets_leggings")
	public static final Item legs = null;
	@ObjectHolder("kitchen_sink:void_jets_boots")
	public static final Item boots = null;
	public VoidJetsItem(KitchenSinkModElements instance) {
		super(instance, 167);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 120;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 0, 0, 0}[slot.getIndex()];
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
				return "void_jets";
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
				armorModel.bipedBody = new Modeljetpackvoid().body;
				armorModel.bipedLeftArm = new Modeljetpackvoid().arms;
				armorModel.bipedRightArm = new Modeljetpackvoid().arms;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "kitchen_sink:textures/jetpackvoid.png";
			}
		}.setRegistryName("void_jets_chestplate"));
	}
	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modeljetpackvoid extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer bone;
		private final ModelRenderer bone4;
		private final ModelRenderer bone3;
		private final ModelRenderer bone2;
		private final ModelRenderer arms;
		public Modeljetpackvoid() {
			textureWidth = 32;
			textureHeight = 32;
			body = new ModelRenderer(this);
			body.setRotationPoint(3.0F, 8.0F, 2.0F);
			body.setTextureOffset(0, 16).addBox(-10.0F, -9.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			body.setTextureOffset(8, 8).addBox(-6.0F, 2.0F, 3.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			body.setTextureOffset(0, 8).addBox(-2.0F, 2.0F, 3.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			body.setTextureOffset(14, 14).addBox(2.0F, -9.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, 0.0F, 6.0F, 6.0F, 2.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-6.0F, 6.0F, 0.0F);
			body.addChild(bone);
			setRotationAngle(bone, 0.7854F, 0.0F, 0.0F);
			bone.setTextureOffset(20, 8).addBox(-0.001F, -4.5858F, 4.2426F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(-3.0F, -10.0F, -4.0F);
			body.addChild(bone4);
			setRotationAngle(bone4, 0.0F, 0.0F, -0.7854F);
			bone4.setTextureOffset(16, 0).addBox(-6.0F, -4.0F, 4.001F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(4.0F, -3.0F, -4.0F);
			body.addChild(bone3);
			setRotationAngle(bone3, 0.0F, 0.0F, 0.7854F);
			bone3.setTextureOffset(8, 20).addBox(-6.0F, -4.0F, 4.001F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(-2.0F, 6.0F, 0.0F);
			body.addChild(bone2);
			setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
			bone2.setTextureOffset(20, 20).addBox(-0.001F, -4.5858F, 4.2426F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			arms = new ModelRenderer(this);
			arms.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(arms);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
