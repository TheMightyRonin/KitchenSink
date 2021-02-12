
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
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
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

import net.mcreator.kitchensink.procedures.DeadsupportknightOnEntityTickUpdateProcedure;
import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@KitchenSinkModElements.ModElement.Tag
public class DeadsupportknightEntity extends KitchenSinkModElements.ModElement {
	public static EntityType entity = null;
	public DeadsupportknightEntity(KitchenSinkModElements instance) {
		super(instance, 148);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.6f, 1.8f))
						.build("deadsupportknight").setRegistryName("deadsupportknight");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelsupportknightdead(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("kitchen_sink:textures/supportknight.png");
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
			setNoAI(true);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source.getImmediateSource() instanceof PlayerEntity)
				return false;
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				DeadsupportknightOnEntityTickUpdateProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(999);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(999D);
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelsupportknightdead extends EntityModel<Entity> {
		private final ModelRenderer main;
		private final ModelRenderer leg2;
		private final ModelRenderer leg3;
		private final ModelRenderer body;
		private final ModelRenderer head;
		private final ModelRenderer arm1;
		private final ModelRenderer arm2;
		public Modelsupportknightdead() {
			textureWidth = 100;
			textureHeight = 100;
			main = new ModelRenderer(this);
			main.setRotationPoint(0.0F, 24.0F, 0.0F);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(1.0F, -3.0F, -3.0F);
			main.addChild(leg2);
			setRotationAngle(leg2, 1.5708F, 0.0F, 0.0F);
			leg2.setTextureOffset(16, 47).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			leg2.setTextureOffset(26, 0).addBox(1.0F, 6.0F, -3.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
			leg2.setTextureOffset(38, 25).addBox(1.0F, 1.0F, -3.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(-1.0F, -3.0F, -3.0F);
			main.addChild(leg3);
			setRotationAngle(leg3, 1.5708F, 0.0F, 0.0F);
			leg3.setTextureOffset(32, 0).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			leg3.setTextureOffset(0, 0).addBox(-3.0F, 6.0F, -3.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
			leg3.setTextureOffset(24, 20).addBox(-3.0F, 1.0F, -3.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 7.0F, -3.0F);
			main.addChild(body);
			setRotationAngle(body, -0.1309F, 0.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-5.0F, -26.0F, -3.0F, 10.0F, 14.0F, 6.0F, 0.0F, false);
			body.setTextureOffset(32, 47).addBox(-4.0F, -25.0F, -4.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(26, 30).addBox(-4.0F, -25.0F, 3.0F, 8.0F, 11.0F, 6.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 1.0F, -17.0F);
			main.addChild(head);
			setRotationAngle(head, -0.7418F, 0.0F, 0.0F);
			head.setTextureOffset(0, 20).addBox(-4.0F, -34.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(0, 52).addBox(4.0F, -33.0F, -3.0F, 1.0F, 6.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(50, 50).addBox(-5.0F, -33.0F, -3.0F, 1.0F, 6.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(48, 28).addBox(-3.0F, -33.0F, -5.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(48, 0).addBox(-1.0F, -35.0F, -3.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(24, 16).addBox(-1.0F, -36.0F, -2.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(36, 16).addBox(-1.0F, -34.0F, 4.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(16, 36).addBox(-1.0F, -35.0F, 5.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 20).addBox(-1.0F, -36.0F, 6.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(48, 0).addBox(-1.0F, -36.0F, 7.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(32, 25).addBox(-1.0F, -35.0F, 8.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
			arm1 = new ModelRenderer(this);
			arm1.setRotationPoint(5.0F, -18.0F, 0.0F);
			main.addChild(arm1);
			setRotationAngle(arm1, 0.3054F, 0.0F, 0.0F);
			arm1.setTextureOffset(44, 12).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			arm1.setTextureOffset(40, 70).addBox(1.0F, 9.0F, -24.0F, 2.0F, 2.0F, 28.0F, 0.0F, false);
			arm1.setTextureOffset(0, 70).addBox(0.0F, 8.0F, -28.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			arm2 = new ModelRenderer(this);
			arm2.setRotationPoint(-5.0F, -25.0F, 0.0F);
			main.addChild(arm2);
			arm2.setTextureOffset(0, 36).addBox(-4.0F, 7.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			main.render(matrixStack, buffer, packedLight, packedOverlay);
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
