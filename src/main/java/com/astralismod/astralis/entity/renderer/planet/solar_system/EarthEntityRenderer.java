package com.astralismod.astralis.entity.renderer.planet.solar_system;

import com.astralismod.astralis.entity.planet.solar_system.EarthEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;

public class EarthEntityRenderer extends EntityRenderer<EarthEntity> {
    private static final Identifier PLANET_TEXTURE = Identifier.of("astralis","textures/planet/solar_system/earth.png");

    public EarthEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public void render(EarthEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.translate(0, 1.5, 0); // Move up to center the cube
        matrices.scale(1.0F, 1.0F, 1.0F); // Adjust size if needed
        Matrix4f pose = matrices.peek().getPositionMatrix();
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(PLANET_TEXTURE));
        drawCube(vertexConsumer, pose, light);

    }

    @Override
    public Identifier getTexture(EarthEntity entity) {
        return PLANET_TEXTURE;
    }

    private void drawCube(VertexConsumer builder, Matrix4f pose, int light) {
        float x1 = -0.5F, x2 = 0.5F;
        float y1 = -0.5F, y2 = 0.5F;
        float z1 = -0.5F, z2 = 0.5F;

        drawQuad(builder, x1, y1, z2, x2, y1, z2, x2, y2, z2, x1, y2, z2, light, pose); // Front
        drawQuad(builder, x1, y1, z1, x1, y1, z2, x1, y2, z2, x1, y2, z1, light, pose); // Left
        drawQuad(builder, x2, y1, z1, x2, y1, z2, x2, y2, z2, x2, y2, z1, light, pose); // Right
        drawQuad(builder, x1, y1, z1, x2, y1, z1, x2, y2, z1, x1, y2, z1, light, pose); // Back
        drawQuad(builder, x1, y2, z1, x2, y2, z1, x2, y2, z2, x1, y2, z2, light, pose); // Top
        drawQuad(builder, x1, y1, z1, x2, y1, z1, x2, y1, z2, x1, y1, z2, light, pose); // Bottom
    }

    private static void drawQuad(VertexConsumer builder, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4, int light, Matrix4f pose) {
        builder.vertex(x1, y1, z1).texture(0, 0).light(light).normal(0, 1, 0).overlay(OverlayTexture.DEFAULT_UV);
        builder.vertex(x2, y2, z2).texture(1, 0).light(light).normal(0, 1, 0).overlay(OverlayTexture.DEFAULT_UV);
        builder.vertex(x3, y3, z3).texture(1, 1).light(light).normal(0, 1, 0).overlay(OverlayTexture.DEFAULT_UV);
        builder.vertex(x4, y4, z4).texture(0, 1).light(light).normal(0, 1, 0).overlay(OverlayTexture.DEFAULT_UV);
    }
}
