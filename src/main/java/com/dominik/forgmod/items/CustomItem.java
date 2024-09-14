package com.dominik.forgmod.items;

import com.dominik.forgmod.utilities.ForgmodTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
        return state.is(ForgmodTags.Blocks.MD_VALUABLES);
    }

    //adding an override for append hover text to add a tooltip there
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        //the translation key doesn't have to look like this but it's good to standardize the format of translations
        pTooltipComponents.add(Component.translatable("tooltip.forgmod.custom_item"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
