package com.dominik.forgmod.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodItemsProperties {
    //adding new food item property to be used at item definition
    public static final FoodProperties PINE_CONE = new FoodProperties.Builder().fast().nutrition(4).saturationMod(4).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,300, 2), 1).effect(() -> new MobEffectInstance(MobEffects.JUMP, 300,2), 1).build();
}
