package net.themightmage.fantasticallands.utils;

import java.util.Random;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;


public class LootTableEntry {

	public static Random random = new Random();

	public static ItemStack createEntry(Item i, float c, int max_a, int multi_health, LivingEntity entity) {
		if (random.nextDouble() <= c) {
			int entity_health = (int) entity.getMaxHealth();
			float multiplier = 1;
			if (entity_health > multi_health) {
				float ratio = (entity_health / 20) / 20;
				multiplier = multiplier + (ratio < 0 ? 0 : ratio);
			}
			return new ItemStack(i, random.nextInt(Math.abs((int) (max_a * multiplier))));
		} else return new ItemStack(Blocks.AIR.asItem());
	};
	
};
