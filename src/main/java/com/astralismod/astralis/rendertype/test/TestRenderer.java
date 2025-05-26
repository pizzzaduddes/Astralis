package com.astralismod.astralis.rendertype.test;

import com.astralismod.astralis.Astralis;
import foundry.veil.Veil;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class TestRenderer {

    private static final Identifier RENDER_TYPE = Identifier.of(Astralis.MOD_ID, "test_rendertype");

    public static void render(MatrixStack matrixStack, VertexConsumerProvider bufferSource, int light) {
        RenderLayer renderType = VeilRenderType.get(RENDER_TYPE, "test_texture.png");
        if (renderType == null) {
            // There was an error loading the render type
            return;
        }

        VertexConsumer builder = bufferSource.getBuffer(renderType);
        MatrixStack.Entry pose = matrixStack.peek();

        drawCube(builder, pose, light);
    }

    public static void drawCube(VertexConsumer builder, MatrixStack.Entry pose, int light) {
        float x1 = -1, x2 = 1;
        float y1 = -1, y2 = 1;
        float z1 = -1, z2 = 1;

        drawQuad(builder, x1, y1, z2, x2, y1, z2, x2, y2, z2, x1, y2, z2, light, pose, 1/3f, 0f, 2/3f, 1/3f); // Front
        drawQuad(builder, x1, y1, z1, x1, y1, z2, x1, y2, z2, x1, y2, z1, light, pose, 0f, 1/3f, 1/3f, 2/3f); // Left
        drawQuad(builder, x2, y1, z1, x2, y1, z2, x2, y2, z2, x2, y2, z1, light, pose, 2/3f, 1/3f, 1f, 2/3f); // Right
        drawQuad(builder, x1, y1, z1, x2, y1, z1, x2, y2, z1, x1, y2, z1, light, pose, 1/3f, 2/3f, 2/3f, 1f); // Back
        drawQuad(builder, x1, y2, z1, x2, y2, z1, x2, y2, z2, x1, y2, z2, light, pose, 2/3f, 2/3f, 1f, 1f); // Top
        drawQuad(builder, x1, y1, z1, x2, y1, z1, x2, y1, z2, x1, y1, z2, light, pose, 1/3f, 1/3f, 2/3f, 2/3f); // Bottom
    }

    private static void drawQuad(VertexConsumer builder, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4, int light, MatrixStack.Entry pose, float u1, float v1, float u2, float v2) {
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
