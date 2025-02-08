package dev.arrokoth.zunpet.zunpet.item;

import dev.arrokoth.zunpet.zunpet.registry.zunpetSoundEvents;
import net.minecraft.sounds.SoundEvent;

/**
 * @author Arrokoth
 * @project Zunpet
 * @copyright Copyright © 2025 Arrokoth All Rights Reserved.
 */
public class ItemZunpet extends AbstractItemInstrument {
    public ItemZunpet(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public SoundEvent getSound() {
        return zunpetSoundEvents.ZUNPET_SOUND.get();
    }
}
