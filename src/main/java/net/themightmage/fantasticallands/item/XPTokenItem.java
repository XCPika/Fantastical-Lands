
package net.themightmage.fantasticallands.item;

import net.themightmage.fantasticallands.procedures.XPTokenUsedProcedure;
import net.themightmage.fantasticallands.init.Tabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

public class XPTokenItem extends Item {

	public XPTokenItem() { super(new Item.Properties().tab(Tabs.TAB_FANTASTICAL_LANDS_TAB).stacksTo(64).rarity(Rarity.COMMON)); }

	@Override
	public int getUseDuration(ItemStack itemstack) { return 0; }
	@Override
	public boolean isFoil(ItemStack itemstack) { return true; }

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		XPTokenUsedProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
		return ar;
	}
}
