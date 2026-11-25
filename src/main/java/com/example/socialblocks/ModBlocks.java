package com.example.socialblocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
	public static final Block PURPLE_BLOCK = register("purple_block");
	public static final Block BLUE_BLOCK = register("blue_block");
	public static final Block BLACK_BLOCK = register("black_block");
	public static final Block SMILE_BLOCK = register("smile_block");

	private static Block register(String name) {
		Identifier id = Identifier.of(SocialBlocks.MOD_ID, name);

		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
		Block block = new Block(AbstractBlock.Settings.create()
				.registryKey(blockKey)
				.strength(1.5f, 6.0f)
				.sounds(BlockSoundGroup.STONE));
		Registry.register(Registries.BLOCK, blockKey, block);

		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
		BlockItem item = new BlockItem(block, new Item.Settings()
				.registryKey(itemKey)
				.useBlockPrefixedTranslationKey());
		Registry.register(Registries.ITEM, itemKey, item);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
				.register(entries -> entries.add(item));

		return block;
	}

	public static void init() {
		// Загрузка класса запускает регистрацию блоков.
	}
}
