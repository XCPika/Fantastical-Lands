package net.themightmage.fantasticallands.procedures;

import net.themightmage.fantasticallands.FantasticalLandsMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import java.util.Map;

public class XPForgeGUIConditionTestProcedure {

	public static boolean execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency world for procedure XPForgeGUIConditionTest!");
			return false;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		return world instanceof Level _lvl && _lvl.isDay();
	}
}
