
package net.themightmage.fantasticallands.mixins;

import net.themightmage.fantasticallands.utils.CollectiveEntityEvents;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = LivingEntity.class, priority = 1001)
public abstract class LivingEntityMixin {

	@Inject(method = "dropAllDeathLoot(Lnet/minecraft/world/damagesource/DamageSource;)V", at = @At(value = "TAIL"))
	protected void dropAllDeathLoot(DamageSource damageSource, CallbackInfo ci) {
		LivingEntity livingEntity = (LivingEntity) (Object) this;
		Level world = livingEntity.getCommandSenderWorld();
		CollectiveEntityEvents.ON_ENTITY_IS_DROPPING_LOOT.invoker().onDroppingLoot(world, livingEntity, damageSource);
	}
}