package com.darkeleck.allay;

import com.darkeleck.allay.entity.AllayEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
    /*
     * The entity is registered under the SpawnGroup#CREATURE category, which is what most animals and passive/neutral mobs use.
     * It has a hitbox size of .75x.75, or 12 "pixels" wide (3/4ths of a block).
     */

    public static final EntityType<AllayEntity> ALLAY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("allay", "allay"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AllayEntity::new).dimensions(EntityDimensions.fixed(0.40f, 0.80f)).build()
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(ALLAY, AllayEntity.createMobAttributes());
    }
}
