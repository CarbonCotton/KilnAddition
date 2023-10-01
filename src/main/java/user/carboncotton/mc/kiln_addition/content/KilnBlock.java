package user.carboncotton.mc.kiln_addition.content;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class KilnBlock extends AbstractFurnaceBlock {
	protected KilnBlock(Settings settings) {

		super(settings);
	}


	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {

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

		// only 25% chance to spawn particle
		if(random.nextDouble() > 0.25) {
			return;
		}



		double centerX = (double)pos.getX() + 0.5;
		double centerY = pos.getY();
		double centerZ = (double)pos.getZ() + 0.5;


		Direction direction = state.get(FACING);
		Direction.Axis axis = direction.getAxis();


		double randomOffset = random.nextDouble() * 0.65 - 0.3;



		double offsetY = 0.23;

		double offsetX = (axis == Direction.Axis.X) ?
				direction.getOffsetX() * 0.52 :
				randomOffset;

		double offsetZ = (axis == Direction.Axis.Z) ?
				direction.getOffsetZ() * 0.52 :
				randomOffset;


		world.addParticle(
				ParticleTypes.FLAME,
				centerX + offsetX,
				centerY + offsetY,
				centerZ + offsetZ,
				0, 0.03,0
		);
	}
}
