package user.carboncotton.mc.kiln_addition.content;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class AllObjects {
	public static Block KILN_BLOCK;

	public static Item KILN_BLOCK_ITEM;

	public static BlockEntityType<KilnBlockEntity> KILN_BLOCK_ENTITY;


	public static RecipeType<FiringRecipe> FIRING_RECIPE_TYPE;


	public static RecipeSerializer<FiringRecipe> FIRING_RECIPE_SERIALIZER;


	public static ScreenHandlerType<KilnScreenHandler> KILN_SCREEN_HANDLER;


	public static Identifier INTERACT_WITH_KILN_STAT;

	public static void init(String namespace) {
		final var KilnId 	= new Identifier(namespace, "kiln");
		final var FiringId 	= new Identifier(namespace, "firing");
		final var StatId 	= new Identifier(namespace, "interact_with_kiln");


		KILN_BLOCK = Registry.register(
		  Registries.BLOCK,
		  KilnId,
		  new KilnBlock(
			AbstractBlock.Settings.create()
			  .mapColor(MapColor.STONE_GRAY)
			  .instrument(Instrument.BASEDRUM)
			  .requiresTool()
			  .strength(3.5F)
			  .luminance( (state) -> (Boolean)state.get(Properties.LIT) ? 13 : 0 )
		  )
		);


		KILN_BLOCK_ITEM = Registry.register(
		  Registries.ITEM,
		  KilnId,
		  new BlockItem(KILN_BLOCK, new Item.Settings())
		);


		KILN_BLOCK_ENTITY = Registry.register(
		  Registries.BLOCK_ENTITY_TYPE,
		  KilnId,
		  FabricBlockEntityTypeBuilder.create(KilnBlockEntity::new, KILN_BLOCK).build()
		);


		FIRING_RECIPE_TYPE  = Registry.register(
		  Registries.RECIPE_TYPE,
		  FiringId,
		  new RecipeType<FiringRecipe>() {
			  @Override
			  public String toString() {
				return "firing";
			  }
		  }
		);

		FIRING_RECIPE_SERIALIZER =  Registry.register(
		  Registries.RECIPE_SERIALIZER,
		  FiringId,
		  new CookingRecipeSerializer<>(FiringRecipe::new, 100)
		);


		KILN_SCREEN_HANDLER = Registry.register(
		  Registries.SCREEN_HANDLER,
		  KilnId,
		  new ScreenHandlerType<>(KilnScreenHandler::new, FeatureFlags.VANILLA_FEATURES)
		);


		INTERACT_WITH_KILN_STAT = Registry.register(
		  Registries.CUSTOM_STAT,
		  "interact_with_kiln",
		  StatId
		);

		Stats.CUSTOM.getOrCreateStat(StatId, StatFormatter.DEFAULT);
	}
}
