package dev.arrokoth.zunpet.zunpet;

import dev.arrokoth.zunpet.zunpet.client.screen.HudInstrument;
import dev.arrokoth.zunpet.zunpet.registry.zunpetItems;
import dev.arrokoth.zunpet.zunpet.registry.zunpetSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * @author Arrokoth
 * @project Zunpet
 * @copyright Copyright © 2025 Arrokoth All Rights Reserved.
 */
@Mod("zunpet")
public class Zunpet {
    public static final String MOD_ID = "zunpet";

    public Zunpet(){
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        zunpetItems.ITEMS.register(modBus);
        zunpetSoundEvents.SOUND_EVENTS.register(modBus);
        Mod.EventBusSubscriber.Bus.MOD.bus().get().addListener(this::clientSetup);
        modBus.addListener(this::addItemsToTabs);
    }


    private void clientSetup(final FMLClientSetupEvent event) {
        // 客户端初始化代码
        HudInstrument hud = new HudInstrument(Minecraft.getInstance());
    }

    @Mod.EventBusSubscriber(modid = "zunpet", value = Dist.CLIENT)
    public static class ClientEventHandler {

        @SubscribeEvent
        public static void onRenderGameOverlay(RenderGuiOverlayEvent.Post event) {

            HudInstrument hud = new HudInstrument(Minecraft.getInstance());
            hud.render(event.getGuiGraphics());

        }
    }

    private void addItemsToTabs(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.COMBAT)
        {
            event.accept(zunpetItems.ZUN_PET_ITEM);
        }
    }




}
