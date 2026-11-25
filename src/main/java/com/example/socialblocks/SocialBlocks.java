package com.example.socialblocks;

import net.fabricmc.api.ModInitializer;

public class SocialBlocks implements ModInitializer {
	public static final String MOD_ID = "socialblocks";

	@Override
	public void onInitialize() {
		ModBlocks.init();
	}
}
