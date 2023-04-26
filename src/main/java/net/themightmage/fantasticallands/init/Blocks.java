
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.themightmage.fantasticallands.init;

import net.themightmage.fantasticallands.block.XpForgeBlock;
import net.themightmage.fantasticallands.FantasticalLandsMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class Blocks {
	public static Block XP_FORGE;

	public static void load() {
		XP_FORGE = Registry.register(Registry.BLOCK, new ResourceLocation(FantasticalLandsMod.MODID, "xp_forge"), new XpForgeBlock());
	}

	public static void clientLoad() {
		XpForgeBlock.clientInit();
	}
}
