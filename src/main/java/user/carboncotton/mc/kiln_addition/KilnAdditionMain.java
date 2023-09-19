package user.carboncotton.mc.kiln_addition;

import net.fabricmc.api.ModInitializer;
import user.carboncotton.mc.kiln_addition.content.AllObjects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class KilnAdditionMain implements ModInitializer {

	public static final String MOD_ID = "kiln_addition";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		AllObjects.init(MOD_ID);

		LOGGER.info("mod initialized successfully");
	}
}