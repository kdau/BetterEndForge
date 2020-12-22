package mod.beethoven92.betterendforge.data;

import mod.beethoven92.betterendforge.BetterEnd;
import mod.beethoven92.betterendforge.common.block.TerrainBlock;
import mod.beethoven92.betterendforge.common.block.material.StoneMaterial;
import mod.beethoven92.betterendforge.common.block.material.WoodenMaterial;
import mod.beethoven92.betterendforge.common.block.template.EndSaplingBlock;
import mod.beethoven92.betterendforge.common.block.template.EndVineBlock;
import mod.beethoven92.betterendforge.common.init.ModBlocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockTagsProvider extends BlockTagsProvider
{
	public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) 
	{
		super(generatorIn, BetterEnd.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerTags() 
	{
		ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach((block) -> {
			if (block instanceof TerrainBlock)
			{
				getOrCreateBuilder(BlockTags.NYLIUM).add(block);
				getOrCreateBuilder(Tags.Blocks.END_STONES).add(block);
			}
			if (block instanceof LeavesBlock)
			{
				getOrCreateBuilder(BlockTags.LEAVES).add(block);
			}
			if (block instanceof EndVineBlock)
			{
				getOrCreateBuilder(BlockTags.CLIMBABLE).add(block);
			}
			if (block instanceof EndSaplingBlock)
			{
				getOrCreateBuilder(BlockTags.SAPLINGS).add(block);
			}
		});
		
		getOrCreateBuilder(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.TERMINITE_BLOCK.get());
		getOrCreateBuilder(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.AETERNIUM_BLOCK.get());
		
		getOrCreateBuilder(Tags.Blocks.ORES).add(ModBlocks.ENDER_ORE.get());
		
		getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).add(ModBlocks.TERMINITE_BLOCK.get());
		getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).add(ModBlocks.AETERNIUM_BLOCK.get());
		
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
		getOrCreateBuilder(material.logBlockTag).add(material.log.get(), material.bark.get(), material.log_stripped.get(), material.bark_stripped.get());
		
		getOrCreateBuilder(BlockTags.PLANKS).add(material.planks.get());
		
		getOrCreateBuilder(BlockTags.LOGS).add(material.log.get(), material.bark.get(), material.log_stripped.get(), material.bark_stripped.get());
		
		getOrCreateBuilder(BlockTags.LOGS_THAT_BURN).add(material.log.get(), material.bark.get(), material.log_stripped.get(), material.bark_stripped.get());
		
		getOrCreateBuilder(BlockTags.BUTTONS).add(material.button.get());
		getOrCreateBuilder(BlockTags.WOODEN_BUTTONS).add(material.button.get());
		
		getOrCreateBuilder(BlockTags.PRESSURE_PLATES).add(material.pressurePlate.get());
		getOrCreateBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(material.pressurePlate.get());
		
		getOrCreateBuilder(BlockTags.DOORS).add(material.door.get());
		getOrCreateBuilder(BlockTags.WOODEN_DOORS).add(material.door.get());
		
		getOrCreateBuilder(BlockTags.FENCES).add(material.fence.get());
		getOrCreateBuilder(BlockTags.WOODEN_FENCES).add(material.fence.get());
		
		getOrCreateBuilder(BlockTags.SLABS).add(material.slab.get());
		getOrCreateBuilder(BlockTags.WOODEN_SLABS).add(material.slab.get());
		
		getOrCreateBuilder(BlockTags.STAIRS).add(material.stairs.get());
		getOrCreateBuilder(BlockTags.WOODEN_STAIRS).add(material.stairs.get());

		getOrCreateBuilder(BlockTags.TRAPDOORS).add(material.trapdoor.get());
		getOrCreateBuilder(BlockTags.WOODEN_TRAPDOORS).add(material.trapdoor.get());
		
		// Forge Tags
		getOrCreateBuilder(Tags.Blocks.FENCES).add(material.fence.get());
		getOrCreateBuilder(Tags.Blocks.FENCES_WOODEN).add(material.fence.get());

		getOrCreateBuilder(Tags.Blocks.FENCE_GATES).add(material.gate.get());
		getOrCreateBuilder(Tags.Blocks.FENCE_GATES_WOODEN).add(material.gate.get());
	}
	
	private void registerStoneMaterialTags(StoneMaterial material)
	{
		getOrCreateBuilder(BlockTags.STONE_BRICKS).add(material.bricks.get());
		
		getOrCreateBuilder(BlockTags.WALLS).add(material.wall.get());
		getOrCreateBuilder(BlockTags.WALLS).add(material.brick_wall.get());
		
		getOrCreateBuilder(BlockTags.SLABS).add(material.slab.get());
		getOrCreateBuilder(BlockTags.SLABS).add(material.brick_slab.get());
		
		getOrCreateBuilder(BlockTags.PRESSURE_PLATES).add(material.pressure_plate.get());
		getOrCreateBuilder(BlockTags.STONE_PRESSURE_PLATES).add(material.pressure_plate.get());
		
		// Forge Tags
		getOrCreateBuilder(Tags.Blocks.STONE).add(material.stone.get());
	}
}