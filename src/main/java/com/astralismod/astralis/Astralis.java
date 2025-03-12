package com.astralismod.astralis;

import com.astralismod.astralis.registry.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Astralis implements ModInitializer {
	public static final String MOD_ID = "astralis";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing: " + MOD_ID);
		ModBlocks.registerModBlocks();
	}

	public static Identifier resLoc(String path) {
		return Identifier.of(MOD_ID, path);
	}
}