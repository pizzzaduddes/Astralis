package com.astralismod.astralis.registry;

import com.astralismod.astralis.Astralis;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {
    public static final Block ROCKET_STEEL = register("rocket_steel",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));

    public static final Block ROCKET_STEEL_TILES = register("rocket_steel_tiles",
            new Block(AbstractBlock.Settings.copy(ModBlocks.ROCKET_STEEL)));

    public static final Block ROCKET_STEEL_GRATES = register("rocket_steel_grates",
            new Block(AbstractBlock.Settings.copy(ModBlocks.ROCKET_STEEL)));

    // Moon Blocks
    public static final Block MOON_SOIL = register("moon_soil",
            new Block(AbstractBlock.Settings.copy(Blocks.GRAVEL)));

    public static final Block MOON_STONE_BRICKS = register("moon_stone_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)));

    public static <T extends Block> T register(String name, T block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Astralis.resLoc(name), block);
    }

    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Astralis.resLoc(name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Astralis.LOGGER.info("Registering Blocks For: " + Astralis.MOD_ID);
    }
}
