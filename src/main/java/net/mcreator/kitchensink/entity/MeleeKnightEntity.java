
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

import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.mcreator.kitchensink.procedures.MeleeKnightOnInitialEntitySpawnProcedure;
import net.mcreator.kitchensink.procedures.MeleeKnightEntityDiesProcedure;
import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@KitchenSinkModElements.ModElement.Tag
public class MeleeKnightEntity extends KitchenSinkModElements.ModElement {
	public static EntityType entity = null;
	public MeleeKnightEntity(KitchenSinkModElements instance) {
		super(instance, 99);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(500).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("melee_knight")
						.setRegistryName("melee_knight");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("melee_knight_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelmeleeknight(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("kitchen_sink:textures/meleeknight.png");
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
			experienceValue = 333;
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
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
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
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.step")), 0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.hit"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.CACTUS)
				return false;
			return super.attackEntityFrom(source, amount);
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
				MeleeKnightEntityDiesProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata,
				CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				MeleeKnightOnInitialEntitySpawnProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(250);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1D);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK);
			this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(2D);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PINK, BossInfo.Overlay.PROGRESS);
		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelmeleeknight extends EntityModel<Entity> {
		private final ModelRenderer main;
		private final ModelRenderer body;
		private final ModelRenderer legr;
		private final ModelRenderer legl;
		private final ModelRenderer head;
		private final ModelRenderer tophorn;
		private final ModelRenderer tophorn2;
		private final ModelRenderer tophorn3;
		private final ModelRenderer arml;
		private final ModelRenderer arml2;
		private final ModelRenderer shield;
		public Modelmeleeknight() {
			textureWidth = 80;
			textureHeight = 80;
			main = new ModelRenderer(this);
			main.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -19.3125F, -0.5F);
			main.addChild(body);
			body.setTextureOffset(0, 43).addBox(-1.0F, 7.3125F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);
			body.setTextureOffset(21, 0).addBox(-6.0F, -7.6875F, -2.5F, 12.0F, 11.0F, 6.0F, 0.0F, false);
			body.setTextureOffset(38, 17).addBox(-5.5F, 3.3125F, -2.0F, 11.0F, 4.0F, 5.0F, 0.0F, false);
			body.setTextureOffset(38, 26).addBox(-5.0F, -6.6875F, 3.5F, 10.0F, 9.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(12, 38).addBox(-4.0F, -5.6875F, 4.5F, 8.0F, 7.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(46, 38).addBox(-5.0F, -6.6875F, -3.5F, 10.0F, 6.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(51, 0).addBox(-4.0F, -5.6875F, -4.5F, 8.0F, 4.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(57, 12).addBox(-3.0F, -0.6875F, -3.5F, 6.0F, 3.0F, 1.0F, 0.0F, false);
			legr = new ModelRenderer(this);
			legr.setRotationPoint(1.0F, -12.5F, 0.0F);
			main.addChild(legr);
			legr.setTextureOffset(56, 45).addBox(0.0F, 0.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			legr.setTextureOffset(38, 56).addBox(0.5F, 3.5F, -1.5F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			legl = new ModelRenderer(this);
			legl.setRotationPoint(-1.0F, -12.5F, 0.0F);
			main.addChild(legl);
			legl.setTextureOffset(57, 5).addBox(-4.0F, 0.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			legl.setTextureOffset(50, 56).addBox(-3.5F, 3.5F, -1.5F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -26.8542F, -0.125F);
			main.addChild(head);
			head.setTextureOffset(22, 38).addBox(-4.0F, -8.1458F, -3.875F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(22, 54).addBox(-3.5F, -7.8958F, -4.875F, 7.0F, 7.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 68).addBox(-5.0F, -9.1458F, -2.875F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(65, 16).addBox(-1.0F, -9.1458F, 3.125F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(62, 32).addBox(-1.0F, -15.1458F, 3.125F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(62, 26).addBox(-6.0F, -13.1458F, -3.875F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(0, 37).addBox(-1.0F, -13.1458F, 4.125F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(62, 62).addBox(4.0F, -13.1458F, -3.875F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(32, 66).addBox(3.0F, -9.1458F, -2.875F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			tophorn = new ModelRenderer(this);
			tophorn.setRotationPoint(0.0F, -16.6458F, 2.625F);
			head.addChild(tophorn);
			setRotationAngle(tophorn, 1.0472F, 0.0F, 0.0F);
			tophorn.setTextureOffset(12, 7).addBox(-0.5F, -1.0F, -1.366F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			tophorn2 = new ModelRenderer(this);
			tophorn2.setRotationPoint(3.0F, -13.6458F, -1.375F);
			head.addChild(tophorn2);
			setRotationAngle(tophorn2, -1.0472F, -0.7854F, 0.0F);
			tophorn2.setTextureOffset(12, 2).addBox(-0.5F, -1.0F, -0.634F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			tophorn3 = new ModelRenderer(this);
			tophorn3.setRotationPoint(-4.0F, -13.6458F, -1.375F);
			head.addChild(tophorn3);
			setRotationAngle(tophorn3, -1.0472F, 0.7854F, 0.0F);
			tophorn3.setTextureOffset(12, 12).addBox(0.2071F, -1.6124F, -0.2804F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			arml = new ModelRenderer(this);
			arml.setRotationPoint(0.0F, -27.0F, 0.0F);
			main.addChild(arml);
			arml.setTextureOffset(19, 27).addBox(6.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			arml.setTextureOffset(0, 19).addBox(6.5F, 3.0F, -1.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
			arml.setTextureOffset(59, 52).addBox(7.0F, 12.9F, -3.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
			arml.setTextureOffset(0, 0).addBox(7.0F, 12.9F, -21.0F, 2.0F, 2.0F, 17.0F, 0.0F, false);
			arml.setTextureOffset(46, 46).addBox(7.5F, 12.9F, -29.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
			arml.setTextureOffset(19, 20).addBox(7.5F, 11.9F, -21.0F, 1.0F, 1.0F, 17.0F, 0.0F, false);
			arml.setTextureOffset(0, 19).addBox(7.5F, 14.9F, -21.0F, 1.0F, 1.0F, 17.0F, 0.0F, false);
			arml.setTextureOffset(52, 28).addBox(7.5F, 13.4F, -37.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
			arml.setTextureOffset(22, 62).addBox(5.5F, 11.4F, -4.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
			arml2 = new ModelRenderer(this);
			arml2.setRotationPoint(0.0F, -27.0F, 0.0F);
			main.addChild(arml2);
			arml2.setTextureOffset(19, 19).addBox(-10.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			arml2.setTextureOffset(0, 0).addBox(-9.5F, 3.0F, -1.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
			shield = new ModelRenderer(this);
			shield.setRotationPoint(0.0F, -27.0F, 0.0F);
			main.addChild(shield);
			shield.setTextureOffset(9, 0).addBox(-10.0F, 8.0F, 1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			shield.setTextureOffset(0, 15).addBox(-10.0F, 8.0F, -2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			shield.setTextureOffset(0, 37).addBox(-10.5F, -2.0F, -4.5F, 1.0F, 21.0F, 10.0F, 0.0F, false);
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
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.shield.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.legr.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.legl.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.arml.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.arml2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
