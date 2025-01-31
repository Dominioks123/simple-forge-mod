package com.dominik.forgmod.blocks;

import com.dominik.forgmod.Forgmod;
import com.dominik.forgmod.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    //custom registry
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Forgmod.MODID);
    //custom blocks registering
    public static final RegistryObject<Block> GEM_BLOCK = RegisterBlock("gem_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> CUSTOM_BLOCK = RegisterBlock("custom_block", () -> new CustomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    //function that registers custom blocks with their custom items.
    private static <T extends Block> RegistryObject<T> RegisterBlock(String name, Supplier<T> BlockToAdd){
        RegistryObject<T> returnit = BLOCKS.register(name, BlockToAdd);
        RegisterBlockItem(name, returnit);
        return returnit;
    };

    //function that registers custom block items
    private static <T extends Block> RegistryObject<Item> RegisterBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    //function that registers custom block registry
    public static void Register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
