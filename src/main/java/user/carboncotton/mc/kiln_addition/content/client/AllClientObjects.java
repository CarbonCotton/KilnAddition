package user.carboncotton.mc.kiln_addition.content.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import user.carboncotton.mc.kiln_addition.content.AllObjects;

@Environment(EnvType.CLIENT)
public class AllClientObjects {

	public static void init() {


		HandledScreens.register(AllObjects.KILN_SCREEN_HANDLER, KilnScreen::new);
	}
}
