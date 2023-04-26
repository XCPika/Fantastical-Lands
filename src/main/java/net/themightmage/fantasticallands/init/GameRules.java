package net.themightmage.fantasticallands.init;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;

public class GameRules {
	public static net.minecraft.world.level.GameRules.Key<net.minecraft.world.level.GameRules.BooleanValue> ALLOWCOINDROPSGAMERULE;

	public static void load() {
		ALLOWCOINDROPSGAMERULE = GameRuleRegistry.register("allowCoinDropsGameRule", net.minecraft.world.level.GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
	}
}
