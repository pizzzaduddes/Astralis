package com.astralismod.astralis.datagen;

import com.astralismod.astralis.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ROCKET_STEEL);
        addDrop(ModBlocks.ROCKET_STEEL_TILES);
        addDrop(ModBlocks.ROCKET_STEEL_GRATES);
        addDrop(ModBlocks.MOON_SOIL);
        addDrop(ModBlocks.MOON_STONE_BRICKS);
    }
}
