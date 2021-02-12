
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Random;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@KitchenSinkModElements.ModElement.Tag
public class VoidroachEntity extends KitchenSinkModElements.ModElement {
	public static EntityType entity = null;
	public VoidroachEntity(KitchenSinkModElements instance) {
		super(instance, 149);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("voidroach")
						.setRegistryName("voidroach");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16777216, -16777216, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("voidroach_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelvoidroach(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("kitchen_sink:textures/voidroach.png");
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
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new AvoidEntityGoal(this, PlayerEntity.class, (float) 10, 1, 1.2));
			this.goalSelector.addGoal(2, new AvoidEntityGoal(this, ServerPlayerEntity.class, (float) 10, 1, 1.2));
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.squish"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0);
		}

		public void livingTick() {
			super.livingTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Random random = this.rand;
			Entity entity = this;
			if (true)
				for (int l = 0; l < 1; ++l) {
					double d0 = (x + random.nextFloat());
					double d1 = (y + random.nextFloat());
					double d2 = (z + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.2000000014901161D;
					double d4 = (random.nextFloat() - 0.5D) * 0.2000000014901161D;
					double d5 = (random.nextFloat() - 0.5D) * 0.2000000014901161D;
					world.addParticle(ParticleTypes.SQUID_INK, d0, d1, d2, d3, d4, d5);
				}
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelvoidroach extends EntityModel<Entity> {
		private final ModelRenderer bone2;
		private final ModelRenderer body;
		private final ModelRenderer body2;
		private final ModelRenderer body3;
		private final ModelRenderer body4;
		private final ModelRenderer body5;
		private final ModelRenderer body6;
		private final ModelRenderer bone;
		public Modelvoidroach() {
			textureWidth = 32;
			textureHeight = 32;
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone2.addChild(body);
			body.setTextureOffset(11, 7).addBox(-2.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body2 = new ModelRenderer(this);
			body2.setRotationPoint(-1.5F, -1.0F, 0.5F);
			bone2.addChild(body2);
			body2.setTextureOffset(0, 9).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body3 = new ModelRenderer(this);
			body3.setRotationPoint(-1.0F, -1.0F, -1.5F);
			bone2.addChild(body3);
			body3.setTextureOffset(0, 7).addBox(-1.0F, 0.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body4 = new ModelRenderer(this);
			body4.setRotationPoint(1.0F, -1.0F, -2.5F);
			bone2.addChild(body4);
			body4.setTextureOffset(0, 4).addBox(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body5 = new ModelRenderer(this);
			body5.setRotationPoint(1.0F, -1.0F, 0.5F);
			bone2.addChild(body5);
			body5.setTextureOffset(0, 2).addBox(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body6 = new ModelRenderer(this);
			body6.setRotationPoint(1.0F, -1.0F, 2.5F);
			bone2.addChild(body6);
			body6.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone2.addChild(bone);
			bone.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
			bone.setTextureOffset(0, 7).addBox(-1.5F, -3.0F, -2.5F, 3.0F, 1.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.body2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.body3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.body4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.body5.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.body.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.body6.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
