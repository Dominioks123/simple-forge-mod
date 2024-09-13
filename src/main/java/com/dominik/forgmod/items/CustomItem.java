package com.dominik.forgmod.items;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class CustomItem extends Item {
    public CustomItem(Properties pProperties) {
        super(pProperties);
    }

    //overriding the useOn method of Item
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean found = false;
            for (int i = 0; i <= positionClicked.getY() +64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isWantedBlock(state)) {
                    found = true;
                    Block block = state.getBlock();
                    assert player != null;
                    player.sendSystemMessage(Component.literal("found " + I18n.get(block.getDescriptionId()) + "at X: " + positionClicked.below(i).getX() + " Y: " + positionClicked.below(i).getY() + " Z: " + positionClicked.below(i).getZ()));
                }
            }
            if (!found) {
                assert player != null;
                player.sendSystemMessage(Component.literal("nothing found"));
            }
        }

        return InteractionResult.SUCCESS;
    }

    private boolean isWantedBlock(BlockState state) {
        return state.is(Blocks.GOLD_ORE) || state.is(Blocks.IRON_ORE) || state.is(Blocks.DIAMOND_ORE);
    }
}
