package com.astralismod.astralis.entity.renderer.planet.solar_system;

import com.astralismod.astralis.Astralis;
import com.astralismod.astralis.entity.renderer.planet.Planet;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class EarthEntityRenderer<T extends Entity & Planet> extends EntityRenderer<T> {
    private static final Identifier PLANET_TEXTURE = Astralis.resLoc("textures/planet/solar_system/earth.png");

    public EarthEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public void render(T entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        entity.render(entity ,yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(T entity) {
        return PLANET_TEXTURE;
    }

    @Override
    public boolean shouldRender(T entity, Frustum frustum, double x, double y, double z) {
        return true;
    }
}
