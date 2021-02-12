package net.mcreator.kitchensink.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import net.mcreator.kitchensink.block.CopperBlockBlock;
import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Map;

@KitchenSinkModElements.ModElement.Tag
public class RainmakerRedstoneofffProcedure extends KitchenSinkModElements.ModElement {
	public RainmakerRedstoneofffProcedure(KitchenSinkModElements instance) {
		super(instance, 49);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RainmakerRedstoneofff!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure RainmakerRedstoneofff!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure RainmakerRedstoneofff!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure RainmakerRedstoneofff!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure RainmakerRedstoneofff!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((CopperBlockBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
				.getBlock())) {
			if ((CopperBlockBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z)))
					.getBlock())) {
				if ((CopperBlockBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z)))
						.getBlock())) {
					if ((CopperBlockBlock.block.getDefaultState()
							.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock())) {
						if ((CopperBlockBlock.block.getDefaultState()
								.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock())) {
							if ((CopperBlockBlock.block.getDefaultState()
									.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock())) {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager().handleCommand(
												_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
												"gamerule doWeatherCycle false");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager().handleCommand(
												_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "weather thunder");
									}
								}
							} else {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager()
												.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "weather rain");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager().handleCommand(
												_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
												"gamerule doWeatherCycle false");
									}
								}
							}
						} else {
							{
								Entity _ent = entity;
								if (!_ent.world.isRemote && _ent.world.getServer() != null) {
									_ent.world.getServer().getCommandManager()
											.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "weather clear");
								}
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent.world.getServer() != null) {
								_ent.world.getServer().getCommandManager()
										.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "weather clear");
							}
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager()
									.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "weather clear");
						}
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager()
								.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "weather clear");
					}
				}
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"weather clear");
				}
			}
		}
	}
}
