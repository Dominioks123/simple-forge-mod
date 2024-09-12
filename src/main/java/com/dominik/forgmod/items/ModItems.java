package com.dominik.forgmod.items;

import com.dominik.forgmod.Forgmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Forgmod.MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Forgmod.MODID);
    public static final RegistryObject<CreativeModeTab> FORGMOD_TAB = TABS.register("forgmod_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GEM.get())).title(Component.translatable("creativetab.forgmod_tab")).build());
    public static final RegistryObject<Item> GEM = ITEMS.register("gem",() -> new Item(new Item.Properties()));

    public static void Register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static void RegisterTab(IEventBus eventBus) {
        TABS.register(eventBus);
    }


}
