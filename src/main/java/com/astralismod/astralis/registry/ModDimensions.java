package com.astralismod.astralis.registry;

import com.astralismod.astralis.Astralis;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> SOL_SYSTEM_KEY = RegistryKey.of(
            RegistryKeys.WORLD,
            Astralis.resLoc("sol_system")
    );

    public static final RegistryKey<DimensionType> SOL_SYSTEM_TYPE_KEY = RegistryKey.of(
            RegistryKeys.DIMENSION_TYPE,
            Astralis.resLoc("sol_system_type")
    );

    public static void registerModDimensions() {
        Astralis.LOGGER.info("Registering Dimensions For: " + Astralis.MOD_ID);
    }

}
