package net.themightmage.fantasticallands.utils;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public final class CollectiveEntityEvents {

	private CollectiveEntityEvents() { }

    public static final Event<CollectiveEntityEvents.Entity_Is_Dropping_Loot> ON_ENTITY_IS_DROPPING_LOOT = 
		EventFactory.createArrayBacked(CollectiveEntityEvents.Entity_Is_Dropping_Loot.class, 
			callbacks -> (world, entity, damageSource) -> {
				for (CollectiveEntityEvents.Entity_Is_Dropping_Loot callback : callbacks) {
					callback.onDroppingLoot(world, entity, damageSource);
				}
			}
		);
	
	@FunctionalInterface
	public interface Entity_Is_Dropping_Loot { void onDroppingLoot(Level world, Entity entity, DamageSource damageSource); }
	
}