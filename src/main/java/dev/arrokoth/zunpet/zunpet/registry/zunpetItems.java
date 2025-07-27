package dev.arrokoth.zunpet.zunpet.registry;

import dev.arrokoth.zunpet.zunpet.item.ItemZunpet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class zunpetItems {

    private static final String MOD_ID = "zunpet";
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredHolder<Item, Item> ZUN_PET_ITEM = ITEMS.register("zunpet",() -> new ItemZunpet(new Item.Properties()));

}
