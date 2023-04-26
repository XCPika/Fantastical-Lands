package net.themightmage.fantasticallands.init;

import net.themightmage.fantasticallands.client.gui.XPForgeGUIScreen;

import net.minecraft.client.gui.screens.MenuScreens;

public class Screens {
	public static void load() {
		MenuScreens.register(Menus.XP_FORGE_GUI, XPForgeGUIScreen::new);
	}
}
