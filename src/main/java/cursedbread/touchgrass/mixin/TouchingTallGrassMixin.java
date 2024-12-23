package cursedbread.touchgrass.mixin;

import net.minecraft.core.block.BlockLogicGrass;
import net.minecraft.core.block.BlockLogicTallGrass;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.spongepowered.asm.mixin.Mixin;

import static cursedbread.touchgrass.GRASS.mobdeath;

@Mixin(value= BlockLogicTallGrass.class,remap=false)
public abstract class TouchingTallGrassMixin {

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
