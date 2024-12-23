package cursedbread.touchgrass.mixin;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Player.class, remap = false)
public abstract class GrassDeathMessage extends Mob {

	public GrassDeathMessage(World world) {
		super(world);
	}

	@Inject(method = "getDeathMessage", at = @At("HEAD"), cancellable = true)
	public void addNewDeathMessage(Entity entityKilledBy, CallbackInfoReturnable<String> cir) {
		if (this.world.getBlockId(MathHelper.floor(this.x), MathHelper.floor(this.y), MathHelper.floor(this.z)) == Blocks.GRASS.id()) {
			cir.setReturnValue(this.getDisplayName() + Player.deathMsgColor + " got a fatal grass allergy.");
		}
	}
}
