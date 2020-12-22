package mod.beethoven92.betterendforge.data;

import mod.beethoven92.betterendforge.BetterEnd;
import mod.beethoven92.betterendforge.common.block.TerrainBlock;
import mod.beethoven92.betterendforge.common.block.material.StoneMaterial;
import mod.beethoven92.betterendforge.common.block.material.WoodenMaterial;
import mod.beethoven92.betterendforge.common.block.template.EndSaplingBlock;
import mod.beethoven92.betterendforge.common.init.ModBlocks;
import mod.beethoven92.betterendforge.common.init.ModItems;
import mod.beethoven92.betterendforge.common.init.ModTags;
import net.minecraft.block.LeavesBlock;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModItemTagsProvider extends ItemTagsProvider
{
	public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) 
	{
		super(dataGenerator, blockTagProvider, BetterEnd.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void registerTags() 
	{
		ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach((block) -> {
			if (block instanceof TerrainBlock)
			{
				getOrCreateBuilder(Tags.Items.END_STONES).add(block.asItem());
			}
			if (block instanceof LeavesBlock)
			{
				getOrCreateBuilder(ItemTags.LEAVES).add(block.asItem());
			}
			if (block instanceof EndSaplingBlock)
			{
				getOrCreateBuilder(ItemTags.SAPLINGS).add(block.asItem());
			}
		});
		
		getOrCreateBuilder(Tags.Items.INGOTS).add(ModItems.TERMINITE_INGOT.get());
		getOrCreateBuilder(Tags.Items.INGOTS).add(ModItems.AETERNIUM_INGOT.get());
		
		getOrCreateBuilder(Tags.Items.ORES).add(ModBlocks.ENDER_ORE.get().asItem());
		// Forge Tags
		getOrCreateBuilder(Tags.Items.DUSTS).add(ModItems.ENDER_DUST.get());
		
		getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).add(ModBlocks.TERMINITE_BLOCK.get().asItem());
		getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).add(ModBlocks.AETERNIUM_BLOCK.get().asItem());
		
		// HAMMERS
		getOrCreateBuilder(ModTags.HAMMERS).add(ModItems.IRON_HAMMER.get());
		getOrCreateBuilder(ModTags.HAMMERS).add(ModItems.GOLDEN_HAMMER.get());
		getOrCreateBuilder(ModTags.HAMMERS).add(ModItems.DIAMOND_HAMMER.get());
		getOrCreateBuilder(ModTags.HAMMERS).add(ModItems.NETHERITE_HAMMER.get());
		getOrCreateBuilder(ModTags.HAMMERS).add(ModItems.TERMINITE_HAMMER.get());
		getOrCreateBuilder(ModTags.HAMMERS).add(ModItems.AETERNIUM_HAMMER.get());
		
		// WOODEN MATERIALS
		registerWoodenMaterialTags(ModBlocks.MOSSY_GLOWSHROOM);
		registerWoodenMaterialTags(ModBlocks.LACUGROVE);
		registerWoodenMaterialTags(ModBlocks.END_LOTUS);
		registerWoodenMaterialTags(ModBlocks.PYTHADENDRON);
		registerWoodenMaterialTags(ModBlocks.DRAGON_TREE);
		registerWoodenMaterialTags(ModBlocks.TENANEA);
		
		// STONE MATERIALS
		registerStoneMaterialTags(ModBlocks.FLAVOLITE);
		registerStoneMaterialTags(ModBlocks.VIOLECITE);
	}
	
	private void registerWoodenMaterialTags(WoodenMaterial material)
	{
		this.copy(material.logBlockTag, material.logItemTag);
	
		getOrCreateBuilder(ItemTags.PLANKS).add(material.planks.get().asItem());
		
		getOrCreateBuilder(ItemTags.LOGS).add(material.log.get().asItem(), material.bark.get().asItem(), material.log_stripped.get().asItem(), material.bark_stripped.get().asItem());
		
		getOrCreateBuilder(ItemTags.LOGS_THAT_BURN).add(material.log.get().asItem(), material.bark.get().asItem(), material.log_stripped.get().asItem(), material.bark_stripped.get().asItem());
		
		getOrCreateBuilder(ItemTags.BUTTONS).add(material.button.get().asItem());
		getOrCreateBuilder(ItemTags.WOODEN_BUTTONS).add(material.button.get().asItem());
		
		getOrCreateBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(material.pressurePlate.get().asItem());
		
		getOrCreateBuilder(ItemTags.DOORS).add(material.door.get().asItem());
		getOrCreateBuilder(ItemTags.WOODEN_DOORS).add(material.door.get().asItem());
		
		getOrCreateBuilder(ItemTags.FENCES).add(material.fence.get().asItem());
		getOrCreateBuilder(ItemTags.WOODEN_FENCES).add(material.fence.get().asItem());
		
		getOrCreateBuilder(ItemTags.SLABS).add(material.slab.get().asItem());
		getOrCreateBuilder(ItemTags.WOODEN_SLABS).add(material.slab.get().asItem());
		
		getOrCreateBuilder(ItemTags.STAIRS).add(material.stairs.get().asItem());
		getOrCreateBuilder(ItemTags.WOODEN_STAIRS).add(material.stairs.get().asItem());
		
		getOrCreateBuilder(ItemTags.TRAPDOORS).add(material.trapdoor.get().asItem());
		getOrCreateBuilder(ItemTags.WOODEN_TRAPDOORS).add(material.trapdoor.get().asItem());
		
		// Forge Tags
		getOrCreateBuilder(Tags.Items.FENCES).add(material.fence.get().asItem());
		getOrCreateBuilder(Tags.Items.FENCES_WOODEN).add(material.fence.get().asItem());

		getOrCreateBuilder(Tags.Items.FENCE_GATES).add(material.gate.get().asItem());
		getOrCreateBuilder(Tags.Items.FENCE_GATES_WOODEN).add(material.gate.get().asItem());
	}
	
	private void registerStoneMaterialTags(StoneMaterial material)
	{
		getOrCreateBuilder(ItemTags.STONE_BRICKS).add(material.bricks.get().asItem());
		
		getOrCreateBuilder(ItemTags.SLABS).add(material.slab.get().asItem());
		getOrCreateBuilder(ItemTags.SLABS).add(material.brick_slab.get().asItem());
		
		getOrCreateBuilder(ItemTags.STONE_CRAFTING_MATERIALS).add(material.stone.get().asItem());
		getOrCreateBuilder(ItemTags.STONE_TOOL_MATERIALS).add(material.stone.get().asItem());
		
		// Forge Tags
		getOrCreateBuilder(Tags.Items.STONE).add(material.stone.get().asItem());
	}
}