package cursedbread.touchgrass.mixin;

import net.minecraft.core.block.BlockGrass;
import net.minecraft.core.block.BlockTallGrass;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.spongepowered.asm.mixin.Mixin;

import static cursedbread.touchgrass.GRASS.mobdeath;

@Mixin(value= BlockTallGrass.class,remap=false)
public abstract class TouchingTallGrassMixin {

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (mobdeath == 1) {
			if (entity instanceof EntityLiving) {
				entity.hurt(null, 1, DamageType.COMBAT);
			}
		} else {
			if (entity instanceof EntityPlayer) {
				entity.hurt(null, 1, DamageType.COMBAT);
			}
		}

	}

}
