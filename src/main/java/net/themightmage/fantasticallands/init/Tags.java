package net.themightmage.fantasticallands.init;

import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;

public class Tags {
	public static final TagKey<Item> COINS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("fantastical_lands:coins"));
}
