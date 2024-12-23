package cursedbread.touchgrass.mixin;

import cursedbread.touchgrass.GRASS;
import net.minecraft.core.block.BlockLogicGrass;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.vehicle.EntityBoat;
import net.minecraft.core.entity.vehicle.EntityMinecart;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static cursedbread.touchgrass.GRASS.*;

@Mixin(value= BlockLogicGrass.class,remap=false)
public abstract class TouchingGrassMixin {

	@Unique
	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return AABB.getTemporaryBB((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 0.9), (double)(z + 1));
	}

	@Unique
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (mobdeath == 1) {
			if (entity instanceof Mob) {
				entity.hurt(null, 1, DamageType.COMBAT);
			}
		} else {
			if (entity instanceof Player) {
				entity.hurt(null, 1, DamageType.COMBAT);
			}
		}
	}
}
