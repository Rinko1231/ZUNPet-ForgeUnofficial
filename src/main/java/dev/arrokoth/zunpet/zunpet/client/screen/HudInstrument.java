package dev.arrokoth.zunpet.zunpet.client.screen;

import com.mojang.blaze3d.platform.Window;
import dev.arrokoth.zunpet.zunpet.Zunpet;
import dev.arrokoth.zunpet.zunpet.item.AbstractItemInstrument;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;

/**
 * @author Arrokoth
 * @project Zunpet
 * @copyright Copyright © 2025 Arrokoth All Rights Reserved.
 */
public class HudInstrument  {
    public static final ResourceLocation NAME_BG =  ResourceLocation.fromNamespaceAndPath(Zunpet.MOD_ID, "textures/hud/name_bg.png");
    public static final ResourceLocation BAR_TEXTURE = ResourceLocation.fromNamespaceAndPath(Zunpet.MOD_ID, "textures/hud/bar.png");
    public static final ResourceLocation POINTER_TEXTURE = ResourceLocation.fromNamespaceAndPath(Zunpet.MOD_ID, "textures/hud/pointer.png");

    private static final String[] NOTE_NAMES = {"C", "D", "E", "F", "G", "A", "H"};
    private final Minecraft minecraft;

    public HudInstrument(Minecraft minecraft) {
        this.minecraft = minecraft;
    }

    public void render(GuiGraphics guiGraphics) { // 参数改为 GuiGraphics
        this.minecraft.getProfiler().push("instrument");
        Window window = Minecraft.getInstance().getWindow();
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null && player.getMainHandItem().getItem() instanceof AbstractItemInstrument) {
            Font textRenderer = Minecraft.getInstance().font;

            float var0 = Math.abs(player.xRotO / 90f * 7f);
            if (player.xRotO > 0) {
                var0 = 7 - var0;
            }
            String name = NOTE_NAMES[(int) (Math.abs(var0 + 0.5f) % 7)];

            // 渲染名称背景
            guiGraphics.blit(
                    NAME_BG,
                    (int) (window.getGuiScaledWidth() / 1.5f - 4),
                    window.getGuiScaledHeight() / 2 - 8,
                    0, 0, 16, 16, 16, 16
            );

            // 渲染音符名称文本
            guiGraphics.drawString(
                    textRenderer,
                    name,
                    (int) (window.getGuiScaledWidth() / 1.5f),
                    (int) (window.getGuiScaledHeight() / 2f - textRenderer.lineHeight / 2f),
                    0xffffff,
                    true
            );

            // 渲染条形背景
            guiGraphics.blit(
                    BAR_TEXTURE,
                    (int) (window.getGuiScaledWidth() / 1.5f + 6),
                    window.getGuiScaledHeight() / 2 - 32,
                    0, 0, 16, 64, 16, 64
            );

            // 渲染指针
            float accurate = (var0 + 0.5f) - ((int) (var0 + 0.5f));
            guiGraphics.blit(
                    POINTER_TEXTURE,
                    (int) (window.getGuiScaledWidth() / 1.5f + 6),
                    window.getGuiScaledHeight() / 2 - 32 + ((int) (60 * accurate)),
                    0, 0, 16, 5, 16, 5
            );
        }
        this.minecraft.getProfiler().pop();
    }


    /*public static void blit(PoseStack p_93134_, int p_93135_, int p_93136_, float p_93137_, float p_93138_, int p_93139_, int p_93140_, int p_93141_, int p_93142_) {
        blit(p_93134_, p_93135_, p_93136_, p_93139_, p_93140_, p_93137_, p_93138_, p_93139_, p_93140_, p_93141_, p_93142_);
    }*/


}
