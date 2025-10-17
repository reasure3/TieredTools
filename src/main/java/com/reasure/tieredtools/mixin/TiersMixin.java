package com.reasure.tieredtools.mixin;

import com.reasure.tieredtools.TieredToolMod;
import net.minecraft.world.item.Tiers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Tiers.class)
public class TiersMixin {
    @Shadow @Final @Mutable
    private int level;

    @Shadow @Final @Mutable
    private int uses;

    @Shadow @Final @Mutable
    private float speed;

    @Shadow @Final @Mutable
    private float damage;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyGoldTier(CallbackInfo cir) {
        // Buff gold tier stats to make it viable between iron and diamond
        TieredToolMod.getLogger().info("Modifying Gold Tier Stats: level 0->2, uses 32->512, speed 12.0->7.0, damage 0.0->2.5");
        TiersMixin gold = (TiersMixin) (Object) Tiers.GOLD;
        gold.level = 2;
        gold.uses = 512;
        gold.speed = 7.0f;
        gold.damage = 2.5f;
    }
}
