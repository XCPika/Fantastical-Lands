
package net.themightmage.fantasticallands.client.gui;

import net.themightmage.fantasticallands.world.inventory.XPForgeGUIMenu;
import net.themightmage.fantasticallands.procedures.XPForgeGUIProgress0Procedure;
import net.themightmage.fantasticallands.procedures.XPForgeGUICondition3Procedure;
import net.themightmage.fantasticallands.procedures.XPForgeGUICondition2Procedure;
import net.themightmage.fantasticallands.procedures.XPForgeGUICondition1Procedure;
import net.themightmage.fantasticallands.procedures.XPForgeGUICondition0Procedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class XPForgeGUIScreen extends AbstractContainerScreen<XPForgeGUIMenu> {
	private final static HashMap<String, Object> guistate = XPForgeGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public XPForgeGUIScreen(XPForgeGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 126;
	}

	private static final ResourceLocation texture = new ResourceLocation("fantastical_lands:textures/screens/xp_forge_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fantastical_lands:textures/screens/coin_outline.png"));
		this.blit(ms, this.leftPos + 25, this.topPos + 21, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fantastical_lands:textures/screens/gray_arrow.png"));
		this.blit(ms, this.leftPos + 43, this.topPos + 21, 0, 0, 16, 16, 16, 16);

		if (XPForgeGUIProgress0Procedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).build())) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("fantastical_lands:textures/screens/green_arrow_fill_1.png"));
			this.blit(ms, this.leftPos + 43, this.topPos + 21, 0, 0, 16, 16, 16, 16);
		}
		if (XPForgeGUICondition1Procedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).build())) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("fantastical_lands:textures/screens/green_arrow_fill_2.png"));
			this.blit(ms, this.leftPos + 43, this.topPos + 21, 0, 0, 16, 16, 16, 16);
		}
		if (XPForgeGUICondition2Procedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).build())) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("fantastical_lands:textures/screens/green_arrow_fill_3.png"));
			this.blit(ms, this.leftPos + 43, this.topPos + 21, 0, 0, 16, 16, 16, 16);
		}
		if (XPForgeGUICondition3Procedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).build())) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("fantastical_lands:textures/screens/green_arrow_fill_4.png"));
			this.blit(ms, this.leftPos + 43, this.topPos + 21, 0, 0, 16, 16, 16, 16);
		}
		if (XPForgeGUICondition0Procedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).build())) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("fantastical_lands:textures/screens/green_arrow_fill_1.png"));
			this.blit(ms, this.leftPos + 83, this.topPos + 21, 0, 0, 16, 16, 16, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.fantastical_lands.xp_forge_gui.label_xp_forge"), 5, 5, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
	}

	public static void screenInit() {
	}
}
