package user.carboncotton.mc.kiln_addition.content;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class KilnScreenHandler extends AbstractFurnaceScreenHandler {
	public KilnScreenHandler(int syncId, PlayerInventory playerInventory) {

		super(AllObjects.KILN_SCREEN_HANDLER, AllObjects.FIRING_RECIPE_TYPE, RecipeBookCategory.BLAST_FURNACE, syncId, playerInventory);
	}

	public KilnScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {

		super(AllObjects.KILN_SCREEN_HANDLER, AllObjects.FIRING_RECIPE_TYPE, RecipeBookCategory.BLAST_FURNACE, syncId, playerInventory, inventory, propertyDelegate);
	}
}
