package net.themightmage.fantasticallands.procedures;

import net.themightmage.fantasticallands.FantasticalLandsMod;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class XPForgeGUICondition2Procedure {

	public static boolean execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency world for procedure XPForgeGUICondition2!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency x for procedure XPForgeGUICondition2!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency y for procedure XPForgeGUICondition2!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency z for procedure XPForgeGUICondition2!");
			return false;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockEntity blockEntity = world.getBlockEntity(new BlockPos(x, y, z));
		if (blockEntity != null) return (blockEntity.getExtraCustomData().getDouble("timer") / 4) >= 10;
		return false;
	}
}
