
package net.mcreator.kitchensink.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.kitchensink.procedures.BeeLauncherBulletHitsBlockProcedure;
import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@KitchenSinkModElements.ModElement.Tag
public class ExplodingbeeEntity extends KitchenSinkModElements.ModElement {
	public static EntityType entity = null;
	public ExplodingbeeEntity(KitchenSinkModElements instance) {
		super(instance, 16);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.4f, 0.4f)).build("explodingbee")
						.setRegistryName("explodingbee");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelbombee(), 0.3f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("kitchen_sink:textures/beefriendly.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				BeeLauncherBulletHitsBlockProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onCollideWithPlayer(PlayerEntity sourceentity) {
			super.onCollideWithPlayer(sourceentity);
			Entity entity = this;
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				BeeLauncherBulletHitsBlockProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelbombee extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer stinger;
		private final ModelRenderer rightwing_bone;
		private final ModelRenderer rightwing_bone_r1;
		private final ModelRenderer leftwing_bone;
		private final ModelRenderer leftwing_bone_r1;
		private final ModelRenderer leg_front;
		private final ModelRenderer leg_mid;
		private final ModelRenderer leg_back;
		public Modelbombee() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.5F, 16.0F, 2.0F);
			setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-3.5F, -4.0F, -5.0F, 7.0F, 7.0F, 10.0F, 0.0F, false);
			body.setTextureOffset(2, 3).addBox(-2.5F, -4.0F, -8.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
			body.setTextureOffset(2, 0).addBox(1.5F, -4.0F, -8.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
			stinger = new ModelRenderer(this);
			stinger.setRotationPoint(0.0F, -1.0F, 1.0F);
			body.addChild(stinger);
			stinger.setTextureOffset(26, 7).addBox(0.0F, 0.0F, 4.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			rightwing_bone = new ModelRenderer(this);
			rightwing_bone.setRotationPoint(-1.5F, -4.0F, -3.0F);
			body.addChild(rightwing_bone);
			setRotationAngle(rightwing_bone, 0.2618F, -0.2618F, 0.0F);
			rightwing_bone_r1 = new ModelRenderer(this);
			rightwing_bone_r1.setRotationPoint(1.0F, 9.0F, 3.0F);
			rightwing_bone.addChild(rightwing_bone_r1);
			setRotationAngle(rightwing_bone_r1, 0.0F, 1.4835F, 1.5708F);
			rightwing_bone_r1.setTextureOffset(0, 18).addBox(-8.4782F, 0.3497F, -14.0F, 9.0F, 0.0F, 6.0F, 0.0F, false);
			leftwing_bone = new ModelRenderer(this);
			leftwing_bone.setRotationPoint(1.5F, -4.0F, -3.0F);
			body.addChild(leftwing_bone);
			setRotationAngle(leftwing_bone, 0.2618F, 0.2618F, 0.0F);
			leftwing_bone_r1 = new ModelRenderer(this);
			leftwing_bone_r1.setRotationPoint(-2.0F, 9.0F, 3.0F);
			leftwing_bone.addChild(leftwing_bone_r1);
			setRotationAngle(leftwing_bone_r1, 0.0F, -1.4399F, -1.5708F);
			leftwing_bone_r1.setTextureOffset(9, 24).addBox(0.2513F, 1.3156F, -14.0F, 9.0F, 0.0F, 6.0F, 0.0F, false);
			leg_front = new ModelRenderer(this);
			leg_front.setRotationPoint(1.5F, 3.0F, -2.0F);
			body.addChild(leg_front);
			leg_front.setTextureOffset(26, 1).addBox(-5.0F, 0.0F, 0.0F, 7.0F, 2.0F, 0.0F, 0.0F, false);
			leg_mid = new ModelRenderer(this);
			leg_mid.setRotationPoint(1.5F, 3.0F, 0.0F);
			body.addChild(leg_mid);
			leg_mid.setTextureOffset(26, 3).addBox(-5.0F, 0.0F, 0.0F, 7.0F, 2.0F, 0.0F, 0.0F, false);
			leg_back = new ModelRenderer(this);
			leg_back.setRotationPoint(1.5F, 3.0F, 2.0F);
			body.addChild(leg_back);
			leg_back.setTextureOffset(26, 5).addBox(-5.0F, 0.0F, 0.0F, 7.0F, 2.0F, 0.0F, 0.0F, false);
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

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.body.rotateAngleY = f2 / 20.f;
		}
	}
}
