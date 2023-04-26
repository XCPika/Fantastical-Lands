package net.themightmage.fantasticallands.events;

import net.themightmage.fantasticallands.init.Items;
import net.themightmage.fantasticallands.utils.LootTableEntry;
import net.themightmage.fantasticallands.FantasticalLandsMod;
import net.themightmage.fantasticallands.config.ConfigLoader;
import net.themightmage.fantasticallands.init.GameRules;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import java.util.ArrayList;
import net.minecraft.world.entity.LivingEntity;


public class MobDropEvent {
	
	public static void dropItems(Level world, Entity entity, DamageSource damageSource) {
		if (world.isClientSide) return;
		if(!world.getGameRules().getBoolean(GameRules.ALLOWCOINDROPSGAMERULE)) return;
		ConfigLoader config = FantasticalLandsMod.CONFIG;
		if (config.BLACKLIST.contains(entity.getType())) return;
		if (!config.ALLOW_SPAWNERS) if (entity.getTags().contains("fromSpawner")) return;
		if (entity instanceof LivingEntity _living) {
			ArrayList<ItemStack> COIN_TABLE = new ArrayList<ItemStack>();
			COIN_TABLE.add(LootTableEntry.createEntry(
				Items.IRON_COIN, 
				(int) config.get("iron_coin_chance").getValue(), 
				(int) config.get("iron_coin_max_amount").getValue(),
				(int) config.get("iron_coin_multiply_amount_after_x_hp").getValue(),
				_living)
			);
			COIN_TABLE.add(LootTableEntry.createEntry(
				Items.GOLD_COIN, 
				(int) config.get("gold_coin_chance").getValue(), 
				(int) config.get("gold_coin_max_amount").getValue(),
				(int) config.get("gold_coin_multiply_amount_after_x_hp").getValue(),
				_living)
			);
			COIN_TABLE.add(LootTableEntry.createEntry(
				Items.EMERALD_COIN, 
				(int) config.get("emerald_coin_chance").getValue(), 
				(int) config.get("emerald_coin_max_amount").getValue(),
				(int) config.get("emerald_coin_multiply_amount_after_x_hp").getValue(),
				_living)
			);
			COIN_TABLE.add(LootTableEntry.createEntry(
				Items.NETHERITE_COIN, 
				(int) config.get("netherite_coin_chance").getValue(), 
				(int) config.get("netherite_coin_max_amount").getValue(),
				(int) config.get("netherite_coin_multiply_amount_after_x_hp").getValue(),
				_living)
			);
			BlockPos epos = entity.blockPosition();
			for (ItemStack item_stack: COIN_TABLE) {
				if (item_stack.getItem() != Blocks.AIR.asItem()) {
					world.addFreshEntity(new ItemEntity(world, epos.getX(), epos.getY()+1, epos.getZ(), item_stack.copy()));
				}
			}
		}
	}
}
