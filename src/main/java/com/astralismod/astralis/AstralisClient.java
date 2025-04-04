package com.astralismod.astralis;

import com.astralismod.astralis.entity.renderer.planet.solar_system.EarthEntityRenderer;
import com.astralismod.astralis.registry.ModDimensions;
import com.astralismod.astralis.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class AstralisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DimensionEffects customEffects = new DimensionEffects(102.0F, true, DimensionEffects.SkyType.END, true, false) {


            @Override
            public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
                return color.multiply(0.0);
            }

            @Override
            public boolean useThickFog(int camX, int camY) {
                return false;
            }

        };

        Identifier effectsId = Identifier.of("astralis", "sol_system_effects");
        DimensionRenderingRegistry.registerDimensionEffects(effectsId, customEffects);

        DimensionRenderingRegistry.registerCloudRenderer(ModDimensions.SOL_SYSTEM_KEY, worldRenderContext -> {

        });

        EntityRendererRegistry.register(ModEntities.EARTH_PLANET, EarthEntityRenderer::new);
    }
}
