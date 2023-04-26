
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.themightmage.fantasticallands.init;

import net.themightmage.fantasticallands.block.entity.XpForgeBlockEntity;
import net.themightmage.fantasticallands.FantasticalLandsMod;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class BlockEntities {
	public static BlockEntityType<?> XP_FORGE;

	public static void load() {
		XP_FORGE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(FantasticalLandsMod.MODID, "xp_forge"), FabricBlockEntityTypeBuilder.create(XpForgeBlockEntity::new, Blocks.XP_FORGE).build(null));
	}
}
