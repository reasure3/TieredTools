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

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyGoldTier(CallbackInfo cir) {
        // Buff gold tier to make it viable between iron and diamond
        TieredToolMod.getLogger().info("Modifying Gold Tier: level 0->2");
        ((TiersMixin) (Object) Tiers.GOLD).level = 2;
    }
}
