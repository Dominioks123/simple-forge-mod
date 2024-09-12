package com.dominik.forgmod.blocks;

import com.dominik.forgmod.Forgmod;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Forgmod.MODID);

    public static void Register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
