package user.carboncotton.mc.kiln_addition.content.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;

import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import user.carboncotton.mc.kiln_addition.content.KilnScreenHandler;

@Environment(EnvType.CLIENT)
public class KilnScreen extends AbstractFurnaceScreen<KilnScreenHandler> {

	//TODO: Create own kiln.png texture
	private static final Identifier TEXTURE = new Identifier("textures/gui/container/blast_furnace.png");

	public KilnScreen(KilnScreenHandler container, PlayerInventory inventory, Text title) {
		super(container, new KilnRecipeBookScreen(), inventory, title, TEXTURE);
	}
}
