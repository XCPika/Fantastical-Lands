package net.themightmage.fantasticallands.procedures;

import net.themightmage.fantasticallands.network.Variables;
import net.themightmage.fantasticallands.init.Items;
import net.themightmage.fantasticallands.init.Tags;
import net.themightmage.fantasticallands.FantasticalLandsMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.fabricmc.fabric.api.transfer.v1.item.PlayerInventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;

import java.util.Map;

public class CoinUsedByPlayerProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency world for procedure CoinUsedByPlayer!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency entity for procedure CoinUsedByPlayer!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency itemstack for procedure CoinUsedByPlayer!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		ItemStack upgrade_coin_type = ItemStack.EMPTY;
		ItemStack item_in_hand = ItemStack.EMPTY;
		item_in_hand = itemstack;
		if (item_in_hand.is(Tags.COINS)) {
			if (!entity.isShiftKeyDown()) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("Upgrade Coins Started"), (true));
				if (!(itemstack.getItem() == Items.NETHERITE_COIN)) {
					if (itemstack.getItem() == Items.IRON_COIN) {
						upgrade_coin_type = new ItemStack(Items.GOLD_COIN);
					} else if (itemstack.getItem() == Items.GOLD_COIN) {
						upgrade_coin_type = new ItemStack(Items.EMERALD_COIN);
					} else {
						upgrade_coin_type = new ItemStack(Items.NETHERITE_COIN);
					}
					if ((itemstack).getCount() >= Variables.MapVariables.get(world).coins_to_convert) {
						if (entity instanceof Player) {
							Player entityPlayer13 = (Player) entity;
							ItemStack stack13 = new ItemStack(upgrade_coin_type.getItem());
							ItemVariant variantof13 = ItemVariant.of(stack13);
							Transaction transaction13 = Transaction.openOuter();
							PlayerInventoryStorage.of(entityPlayer13).offerOrDrop(variantof13, ((itemstack).getCount() / (int) Variables.MapVariables.get(world).coins_to_convert), transaction13);
							transaction13.commit();
						}
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = itemstack;
							_player.getInventory().removeItem(_stktoremove);
						}
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("Downgrade Coins Started"), (true));
				if (!(item_in_hand.getItem() == Items.IRON_COIN)) {
					if (itemstack.getItem() == Items.GOLD_COIN) {
						upgrade_coin_type = new ItemStack(Items.IRON_COIN);
					} else if (itemstack.getItem() == Items.EMERALD_COIN) {
						upgrade_coin_type = new ItemStack(Items.GOLD_COIN);
					} else {
						upgrade_coin_type = new ItemStack(Items.EMERALD_COIN);
					}
					if (entity instanceof Player) {
						Player entityPlayer26 = (Player) entity;
						ItemStack stack26 = new ItemStack(upgrade_coin_type.getItem());
						ItemVariant variantof26 = ItemVariant.of(stack26);
						Transaction transaction26 = Transaction.openOuter();
						PlayerInventoryStorage.of(entityPlayer26).offerOrDrop(variantof26, ((itemstack).getCount() * (int) Variables.MapVariables.get(world).coins_to_convert), transaction26);
						transaction26.commit();
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstack;
						_player.getInventory().removeItem(_stktoremove);
					}
				}
			}
		}
	}
}
