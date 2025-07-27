package dev.arrokoth.zunpet.zunpet;

import dev.arrokoth.zunpet.zunpet.client.screen.HudInstrument;
import dev.arrokoth.zunpet.zunpet.registry.zunpetItems;
import dev.arrokoth.zunpet.zunpet.registry.zunpetSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;


/**
 * @author Arrokoth
 * @project Zunpet
 * @copyright Copyright © 2025 Arrokoth All Rights Reserved.
 */
@Mod("zunpet")
public class Zunpet {
    public static final String MOD_ID = "zunpet";

    public Zunpet(IEventBus modBus){

        zunpetItems.ITEMS.register(modBus);
        zunpetSoundEvents.SOUND_EVENTS.register(modBus);
        modBus.addListener(this::clientSetup);
        modBus.addListener(this::addItemsToTabs);
    }


    private void clientSetup(final FMLClientSetupEvent event) {
        // 客户端初始化代码
        HudInstrument hud = new HudInstrument(Minecraft.getInstance());
    }

    @EventBusSubscriber(modid = "zunpet", value = Dist.CLIENT)
    public static class ClientEventHandler {

        @SubscribeEvent
        public static void onRenderGameOverlay(RenderGuiLayerEvent.Post event) {

            HudInstrument hud = new HudInstrument(Minecraft.getInstance());
            hud.render(event.getGuiGraphics());

        }
    }

    private void addItemsToTabs(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.COMBAT)
        {
            event.accept(zunpetItems.ZUN_PET_ITEM.get());
        }
    }




}
