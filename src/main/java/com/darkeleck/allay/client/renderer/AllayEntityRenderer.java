package com.darkeleck.allay.client.renderer;

import com.darkeleck.allay.Client;
import com.darkeleck.allay.client.model.AllayEntityModel;
import com.darkeleck.allay.entity.AllayEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class AllayEntityRenderer extends MobEntityRenderer<AllayEntity, AllayEntityModel> {

    public AllayEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AllayEntityModel(context.getPart(Client.MODEL_ALLAY_LAYER)), 0.5f);
    }
    @Override
    public Identifier getTexture(AllayEntity entity) {
        return new Identifier("allay", "textures/entity/allay/allay.png");
    }
}
