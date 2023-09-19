package user.carboncotton.mc.kiln_addition;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import user.carboncotton.mc.kiln_addition.content.client.AllClientObjects;

@Environment(EnvType.CLIENT)
public class KilnAdditionClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		AllClientObjects.init();
	}
}
