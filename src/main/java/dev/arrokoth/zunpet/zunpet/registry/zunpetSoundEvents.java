package dev.arrokoth.zunpet.zunpet.registry;

import dev.arrokoth.zunpet.zunpet.Zunpet;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static dev.arrokoth.zunpet.zunpet.Zunpet.MOD_ID;


public class zunpetSoundEvents {

   public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MOD_ID);

   public static final Holder<SoundEvent> ZUNPET_SOUND = createHolderEvent("zunpet");
   private static Supplier<SoundEvent> createEvent(String sound) {
      ResourceLocation name = ResourceLocation.fromNamespaceAndPath(MOD_ID, sound);
      return SOUND_EVENTS.register(sound, () -> SoundEvent.createVariableRangeEvent(name));
   }

   private static Holder<SoundEvent> createHolderEvent(String sound) {
      ResourceLocation name = ResourceLocation.fromNamespaceAndPath(MOD_ID, sound);
      return SOUND_EVENTS.register(sound, () -> SoundEvent.createVariableRangeEvent(name));
   }

}
