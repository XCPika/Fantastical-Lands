package net.themightmage.fantasticallands.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

public class Tabs {
	public static CreativeModeTab TAB_FANTASTICAL_LANDS_TAB;

	public static void load() {
		TAB_FANTASTICAL_LANDS_TAB = FabricItemGroupBuilder.create(new ResourceLocation("fantastical_lands", "fantastical_lands_tab")).icon(() -> new ItemStack(Items.XP_TOKEN)).build();
	}
}
