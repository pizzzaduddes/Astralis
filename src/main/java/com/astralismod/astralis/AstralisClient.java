package com.astralismod.astralis;

import com.astralismod.astralis.entity.renderer.planet.solar_system.EarthEntityRenderer;
import com.astralismod.astralis.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AstralisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.EARTH_PLANET, EarthEntityRenderer::new);
    }
}
