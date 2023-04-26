package net.themightmage.fantasticallands.init;

import net.themightmage.fantasticallands.item.XPTokenItem;
import net.themightmage.fantasticallands.item.NetheriteCoinItem;
import net.themightmage.fantasticallands.item.IronCoinItem;
import net.themightmage.fantasticallands.item.GoldCoinItem;
import net.themightmage.fantasticallands.item.EmeraldCoinItem;
import net.themightmage.fantasticallands.FantasticalLandsMod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class Items {
	public static Item IRON_COIN;
	public static Item GOLD_COIN;
	public static Item EMERALD_COIN;
	public static Item NETHERITE_COIN;
	public static Item XP_TOKEN;
	public static Item XP_FORGE;

	public static void load() {
		IRON_COIN = Registry.register(Registry.ITEM, new ResourceLocation(FantasticalLandsMod.MODID, "iron_coin"), new IronCoinItem());
		GOLD_COIN = Registry.register(Registry.ITEM, new ResourceLocation(FantasticalLandsMod.MODID, "gold_coin"), new GoldCoinItem());
		EMERALD_COIN = Registry.register(Registry.ITEM, new ResourceLocation(FantasticalLandsMod.MODID, "emerald_coin"), new EmeraldCoinItem());
		NETHERITE_COIN = Registry.register(Registry.ITEM, new ResourceLocation(FantasticalLandsMod.MODID, "netherite_coin"), new NetheriteCoinItem());
		XP_TOKEN = Registry.register(Registry.ITEM, new ResourceLocation(FantasticalLandsMod.MODID, "xp_token"), new XPTokenItem());
		XP_FORGE = Registry.register(Registry.ITEM, new ResourceLocation(FantasticalLandsMod.MODID, "xp_forge"), new BlockItem(Blocks.XP_FORGE, new Item.Properties().tab(Tabs.TAB_FANTASTICAL_LANDS_TAB)));
	}
}
