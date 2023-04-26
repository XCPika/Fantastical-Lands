package net.themightmage.fantasticallands;

import net.themightmage.fantasticallands.config.ConfigLoader;
import net.themightmage.fantasticallands.network.Variables;
import net.themightmage.fantasticallands.init.Tabs;
import net.themightmage.fantasticallands.init.FantasticalLandsModProcedures;
import net.themightmage.fantasticallands.init.Menus;
import net.themightmage.fantasticallands.init.Items;
import net.themightmage.fantasticallands.init.Blocks;
import net.themightmage.fantasticallands.init.BlockEntities;
import net.themightmage.fantasticallands.init.GameRules;
import net.themightmage.fantasticallands.events.MobDropEvent;
import net.themightmage.fantasticallands.utils.CollectiveEntityEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class FantasticalLandsMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "fantastical_lands";
	public static final ConfigLoader CONFIG = new ConfigLoader();

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing FantasticalLandsMod");
		Tabs.load();

		Blocks.load();
		Items.load();
		BlockEntities.load();
		GameRules.load();

		FantasticalLandsModProcedures.load();

		Menus.load();
		
		Variables.SyncJoin();
		Variables.SyncChangeWorld();
		
		CollectiveEntityEvents.ON_ENTITY_IS_DROPPING_LOOT.register(
			(Level world, Entity entity, DamageSource damageSource) -> {
				MobDropEvent.dropItems(world, entity, damageSource);
			}
		);
	}
}
