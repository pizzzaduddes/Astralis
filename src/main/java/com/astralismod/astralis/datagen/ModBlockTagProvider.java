package com.astralismod.astralis.datagen;

import com.astralismod.astralis.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ROCKET_STEEL)
                .add(ModBlocks.ROCKET_STEEL_TILES)
                .add(ModBlocks.ROCKET_STEEL_GRATES)
                .add(ModBlocks.MOON_STONE_BRICKS);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ROCKET_STEEL)
                .add(ModBlocks.ROCKET_STEEL_TILES)
                .add(ModBlocks.ROCKET_STEEL_GRATES);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.MOON_SOIL);
    }
}
