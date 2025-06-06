package com.astralismod.astralis.datagen;

import com.astralismod.astralis.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROCKET_STEEL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROCKET_STEEL_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROCKET_STEEL_GRATES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_SOIL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_STONE_BRICKS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
