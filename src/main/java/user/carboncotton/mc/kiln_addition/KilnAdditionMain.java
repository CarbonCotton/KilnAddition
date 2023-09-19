package user.carboncotton.mc.kiln_addition;

import net.fabricmc.api.ModInitializer;
import user.carboncotton.mc.kiln_addition.content.AllObjects;


public class KilnAdditionMain implements ModInitializer {

	public static final String MOD_ID = "kiln_addition";

	@Override
	public void onInitialize() {

		AllObjects.init(MOD_ID);
	}
}