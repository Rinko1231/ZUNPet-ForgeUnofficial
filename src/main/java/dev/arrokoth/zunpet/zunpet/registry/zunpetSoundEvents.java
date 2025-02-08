package dev.arrokoth.zunpet.zunpet.registry;

import dev.arrokoth.zunpet.zunpet.Zunpet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class zunpetSoundEvents {


    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Zunpet.MOD_ID);

    public static final RegistryObject<SoundEvent> ZUNPET_SOUND = SOUND_EVENTS.register("zunpet", () -> new SoundEvent(new ResourceLocation(Zunpet.MOD_ID, "zunpet")));


}
