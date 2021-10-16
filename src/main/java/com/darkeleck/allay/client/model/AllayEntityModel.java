package com.darkeleck.allay.client.model;

import com.darkeleck.allay.entity.AllayEntity;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.mojang.datafixers.TypeRewriteRule;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

public class AllayEntityModel extends EntityModel<AllayEntity> {

    private final ModelPart base;
    private final ModelPart head;
    private final ModelPart rarm;
    private final ModelPart larm;
    private final ModelPart leg;
    private final ModelPart lwing;
    private final ModelPart rwing;

    public AllayEntityModel(ModelPart modelPart) {

        this.rwing = modelPart.getChild(EntityModelPartNames.RIGHT_WING);
        this.lwing = modelPart.getChild(EntityModelPartNames.LEFT_WING);
        this.rarm = modelPart.getChild(EntityModelPartNames.RIGHT_ARM);
        this.larm = modelPart.getChild(EntityModelPartNames.LEFT_ARM);
        this.leg = modelPart.getChild(EntityModelPartNames.CUBE);
        this.head = modelPart.getChild(EntityModelPartNames.HEAD);
        this.base = modelPart.getChild(EntityModelPartNames.BODY);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0.0F);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -18.0F, -4.0F, 8.0F, 8.0F, 8.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(1, 16).cuboid(-2.0F, -10.0F, -2.0F, 4.0F, 7.0F, 3.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.CUBE, ModelPartBuilder.create().uv(0, 33).cuboid(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 3.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_WING, ModelPartBuilder.create().uv(0, 29).cuboid(-20.5F, -13.25F, 0.0F, 18.0F, 10.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild(EntityModelPartNames.LEFT_WING, ModelPartBuilder.create().uv(0, 31).cuboid(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 3.0F), ModelTransform.NONE);
        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(15, 16).cuboid(-4.0F, -10.0F, -1.5F, 2.0F, 5.0F, 2.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(15, 16).cuboid(2.0F, -10.0F, -1.5F, 2.0F, 5.0F, 2.0F), ModelTransform.NONE);

        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setAngles(AllayEntity entity, float f, float g, float h, float i, float j) {
        base.setPivot(0.0F, 24.0F, 0.0F);
        rarm.setPivot(0.0F, 24.0F, 0.0F);
        larm.setPivot(0.0F, 24.0F, 0.0F);
        leg.setPivot(0.0F, 24.0F, 0.0F);
        head.setPivot(0.0F, 24.0F, 0.0F);
        lwing.setPivot(0.0F, 24.0F, 0.0F);
        rwing.setPivot(0.0F, 24.0F, 0.0F);

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.base, this.rarm, this.larm, this.leg, this.head, this.rwing, this.lwing).forEach((modelRenderer) -> {
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        });
    }
}