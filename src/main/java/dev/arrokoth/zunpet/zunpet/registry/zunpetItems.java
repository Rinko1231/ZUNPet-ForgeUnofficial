package dev.arrokoth.zunpet.zunpet.registry;

import dev.arrokoth.zunpet.zunpet.item.ItemZunpet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class zunpetItems {

    private static final String MOD_ID = "zunpet";
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final RegistryObject<Item> ZUN_PET_ITEM = ITEMS.register("zunpet",() -> new ItemZunpet(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

}
