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

    public static final EntityType<AllayEntity> ALLAY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("allay", "allay"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AllayEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(ALLAY, AllayEntity.createMobAttributes());
    }
}
