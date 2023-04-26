package net.themightmage.fantasticallands.init;

import net.themightmage.fantasticallands.world.inventory.XPForgeGUIMenu;
import net.themightmage.fantasticallands.client.gui.XPForgeGUIScreen;
import net.themightmage.fantasticallands.FantasticalLandsMod;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;

public class Menus {
	public static MenuType<XPForgeGUIMenu> XP_FORGE_GUI;

	public static void load() {
		XP_FORGE_GUI = Registry.register(Registry.MENU, new ResourceLocation(FantasticalLandsMod.MODID, "xp_forge_gui"), new ExtendedScreenHandlerType<>(XPForgeGUIMenu::new));
		XPForgeGUIScreen.screenInit();
	}
}
