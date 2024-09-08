package cursedbread.touchgrass.mixin;

import net.minecraft.core.block.BlockGrass;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.vehicle.EntityBoat;
import net.minecraft.core.entity.vehicle.EntityMinecart;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value= BlockGrass.class,remap=false)
public abstract class TouchingGrassMixin {

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityLiving || entity instanceof EntityMinecart || entity instanceof EntityBoat) {
			entity.hurt(null, 1, DamageType.COMBAT);
		}
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		float f = 0.0625f;
		return AABB.getBoundingBoxFromPool((float)x, y, (float)z, (float)(x + 1), (float)(y + 1) - f, (float)(z + 1));
	}
}
