package user.carboncotton.mc.kiln_addition.content;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.slf4j.LoggerFactory;

public class KilnBlock extends AbstractFurnaceBlock {
	protected KilnBlock(Settings settings) {

		super(settings);
	}


	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		LoggerFactory.getLogger("basic_kiln").info("Kiln entity created");


		return new KilnBlockEntity(pos, state);
	}

	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {

		return checkType(world, type, AllObjects.KILN_BLOCK_ENTITY);
	}


	@Override
	protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
		final var blockEntityHere = world.getBlockEntity(pos);

		// if block entity is not our preferred type, return
		if(!(blockEntityHere instanceof KilnBlockEntity)) {
			return;
		}



		// order entity to open menu and increment stat
		player.openHandledScreen((NamedScreenHandlerFactory)blockEntityHere);
		player.incrementStat(AllObjects.INTERACT_WITH_KILN_STAT);
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		// only lit kiln can make noise/effects
		if(!state.get(LIT)) {
			return;
		}

	}
}
