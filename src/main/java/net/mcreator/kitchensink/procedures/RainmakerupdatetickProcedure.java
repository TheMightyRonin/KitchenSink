package net.mcreator.kitchensink.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.kitchensink.block.CopperBlockBlock;
import net.mcreator.kitchensink.KitchenSinkModElements;

import java.util.Map;

@KitchenSinkModElements.ModElement.Tag
public class RainmakerupdatetickProcedure extends KitchenSinkModElements.ModElement {
	public RainmakerupdatetickProcedure(KitchenSinkModElements instance) {
		super(instance, 51);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Rainmakerupdatetick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Rainmakerupdatetick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Rainmakerupdatetick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Rainmakerupdatetick!");
			return;
		}
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
							if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
								world.getWorld().getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
										"weather thunder");
							}
						}
					}
				}
			}
		}
	}
}
