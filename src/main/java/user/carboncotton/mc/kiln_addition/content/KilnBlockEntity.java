package user.carboncotton.mc.kiln_addition.content;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class KilnBlockEntity extends AbstractFurnaceBlockEntity {
	public KilnBlockEntity(BlockPos pos, BlockState state) {

		super(AllObjects.KILN_BLOCK_ENTITY, pos, state, AllObjects.FIRING_RECIPE_TYPE);
	}

	@Override
	public Text getContainerName() {

		return Text.translatable("container.kiln_addition.kiln");
	}

	@Override
	protected int getFuelTime(ItemStack fuel) {

		return super.getFuelTime(fuel) / 2;
	}

	@Override
	public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {

		return new KilnScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
	}
}
