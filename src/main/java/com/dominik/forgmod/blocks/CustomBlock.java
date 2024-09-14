package com.dominik.forgmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CustomBlock extends Block {
    public CustomBlock(Properties bProperties) {
        super(bProperties);
    }

    //overriding stepOn method of block
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        for (int i = 0; i < 32; i++) {
            pLevel.addParticle(ParticleTypes.ANGRY_VILLAGER, pPos.getX(), pPos.getY() + 1, pPos.getZ(), pEntity.getRandomX(1), 2, pEntity.getRandomZ(1));
        }
        pLevel.destroyBlock(pPos, true);
    }

    //overriding use method of block
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.END_PORTAL_SPAWN, SoundSource.BLOCKS);
        for (int i = 0; i < 32; i++) {
            pLevel.addParticle(ParticleTypes.ASH, pPos.getX(), pPos.getY() + 1, pPos.getZ(), pPlayer.getRandom().nextDouble(),2, pPlayer.getRandom().nextDouble());
        }
        return InteractionResult.SUCCESS;
    }
}