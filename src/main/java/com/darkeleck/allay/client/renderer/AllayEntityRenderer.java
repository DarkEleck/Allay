package com.darkeleck.allay.client.renderer;

import com.darkeleck.allay.Client;
import com.darkeleck.allay.client.model.AllayEntityModel;
import com.darkeleck.allay.entity.AllayEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class AllayEntityRenderer extends BipedEntityRenderer<AllayEntity, AllayEntityModel> {

    public AllayEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AllayEntityModel(context.getPart(Client.MODEL_ALLAY_LAYER)), 0.5f);
    }
    @Override
    public Identifier getTexture(AllayEntity entity) {
        return new Identifier("allay", "textures/entity/allay/allay.png");
    }
}
