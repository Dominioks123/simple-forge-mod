package com.dominik.forgmod.utilities;

import com.dominik.forgmod.Forgmod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ForgmodTags {
    //class for blocks tags
    public static class Blocks {
        public static final TagKey<Block> MD_VALUABLES = tag("metal_detector_valuables");

        //helper method for easier creation of blocks tags
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Forgmod.MODID, name));
        }
    }

    //class for item tags
    public static class Items {

        //helper method for easier creation of item tags
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Forgmod.MODID, name));
        }
    }
}
