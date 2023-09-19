package user.carboncotton.mc.kiln_addition.content;


import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.util.Identifier;

public class FiringRecipe extends AbstractCookingRecipe {
	public FiringRecipe(Identifier id, String group, CookingRecipeCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {

		super(AllObjects.FIRING_RECIPE_TYPE, id, group, category, input, output, experience, cookTime);
	}

	@Override
	public ItemStack createIcon() {

		return new ItemStack(AllObjects.KILN_BLOCK);
	}


	@Override
	public RecipeSerializer<?> getSerializer() {

		return AllObjects.FIRING_RECIPE_SERIALIZER;
	}
}
