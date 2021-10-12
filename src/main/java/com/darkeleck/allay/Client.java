package com.darkeleck.allay;

import com.darkeleck.allay.client.model.AllayEntityModel;
import com.darkeleck.allay.client.renderer.AllayEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class Client implements ClientModInitializer {
    public static final EntityModelLayer MODEL_ALLAY_LAYER = new EntityModelLayer(new Identifier("allay", "allay"), "main");
    @Override
    public void onInitializeClient() {

        net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(Main.ALLAY, (context) ->{
            return new AllayEntityRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(MODEL_ALLAY_LAYER, AllayEntityModel::getTexturedModelData);
    }
}
