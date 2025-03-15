package com.astralismod.astralis.entity.renderer.planet;

import com.astralismod.astralis.entity.planet.solar_system.EarthEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

public interface Planet {
    Identifier planetTexture();
    //texture that the planet uses
    float planetSize();
    //size of the planet 1 = 1 block;
    float axialTilt();
    //axial tilt; look it up
    float rotationSpeed();
    //speed of the planet rotating around itself 1 = 1 mc day for a full rotation

    default <T extends Entity & Planet> void render(T entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        MatrixStack.Entry pose = matrices.peek();
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(planetTexture()));

        float time = (entity.getWorld().getTimeOfDay() + tickDelta) % 24000;

        float rotation = time / 24000f * 360f * rotationSpeed();
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(axialTilt()));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));

        drawCube(vertexConsumer, pose, light);

        matrices.pop();
    }

    private void drawCube(VertexConsumer builder, MatrixStack.Entry pose, int light) {
        float planetSize = planetSize() / 2;
        float x1 = -planetSize, x2 = planetSize;
        float y1 = -planetSize, y2 = planetSize;
        float z1 = -planetSize, z2 = planetSize;

        drawQuad(builder, x1, y1, z2, x2, y1, z2, x2, y2, z2, x1, y2, z2, light, pose, 1/3f, 0f, 2/3f, 1/3f); // Front
        drawQuad(builder, x1, y1, z1, x1, y1, z2, x1, y2, z2, x1, y2, z1, light, pose, 0f, 1/3f, 1/3f, 2/3f); // Left
        drawQuad(builder, x2, y1, z1, x2, y1, z2, x2, y2, z2, x2, y2, z1, light, pose, 2/3f, 1/3f, 1f, 2/3f); // Right
        drawQuad(builder, x1, y1, z1, x2, y1, z1, x2, y2, z1, x1, y2, z1, light, pose, 1/3f, 2/3f, 2/3f, 1f); // Back
        drawQuad(builder, x1, y2, z1, x2, y2, z1, x2, y2, z2, x1, y2, z2, light, pose, 2/3f, 2/3f, 1f, 1f); // Top
        drawQuad(builder, x1, y1, z1, x2, y1, z1, x2, y1, z2, x1, y1, z2, light, pose, 1/3f, 1/3f, 2/3f, 2/3f); // Bottom
    }

    private void drawQuad(VertexConsumer builder, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4, int light, MatrixStack.Entry pose, float u1, float v1, float u2, float v2) {
        builder.vertex(pose, x1, y1, z1).color(1.0F, 1.0F, 1.0F, 1.0F)
                .texture(u1, v1).light(light).normal(1, 1, 1)
                .overlay(OverlayTexture.DEFAULT_UV);

        builder.vertex(pose, x2, y2, z2).color(1.0F, 1.0F, 1.0F, 1.0F)
                .texture(u2, v1).light(light).normal(1, 1, 1)
                .overlay(OverlayTexture.DEFAULT_UV);

        builder.vertex(pose, x3, y3, z3).color(1.0F, 1.0F, 1.0F, 1.0F)
                .texture(u2, v2).light(light).normal(1, 1, 1)
                .overlay(OverlayTexture.DEFAULT_UV);

        builder.vertex(pose, x4, y4, z4).color(1.0F, 1.0F, 1.0F, 1.0F)
                .texture(u1, v2).light(light).normal(1, 1, 1)
                .overlay(OverlayTexture.DEFAULT_UV);
    }
}
