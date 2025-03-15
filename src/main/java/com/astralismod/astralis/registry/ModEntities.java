package com.astralismod.astralis.registry;

import com.astralismod.astralis.Astralis;
import com.astralismod.astralis.entity.planet.solar_system.EarthEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEntities {
    public static final EntityType<EarthEntity> EARTH_PLANET = Registry.register(
            Registries.ENTITY_TYPE,
            Astralis.resLoc("earth_planet"),
            EntityType.Builder.create(EarthEntity::new, SpawnGroup.MISC)
                    .dimensions(1.0f, 1.0f)
                    .maxTrackingRange(500)
                    .build());

    public static void registerModEntities() {
        Astralis.LOGGER.info("Registering Entities For: " + Astralis.MOD_ID);
    }
}
