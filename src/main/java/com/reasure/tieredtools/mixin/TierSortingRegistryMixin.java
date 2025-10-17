package com.reasure.tieredtools.mixin;

import com.reasure.tieredtools.TieredToolMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.TierSortingRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(TierSortingRegistry.class)
public abstract class TierSortingRegistryMixin {
    @Shadow(remap = false)
    private static void processTier(Tier tier, ResourceLocation name, List<Object> afters, List<Object> befores) {}

    @Redirect(method = "<clinit>", remap = false, at = @At(value = "INVOKE",
            target = "Lnet/minecraftforge/common/TierSortingRegistry;processTier(Lnet/minecraft/world/item/Tier;Lnet/minecraft/resources/ResourceLocation;Ljava/util/List;Ljava/util/List;)V", ordinal = 1)
    )
    private static void modifyGoldTierOrder(Tier tier, ResourceLocation name, List<Object> afters, List<Object> befores) {
        if (tier == Tiers.GOLD) {
            TieredToolMod.getLogger().info("Modifying {} Tier Order: after iron, before diamond", tier);
            ResourceLocation iron = ResourceLocation.withDefaultNamespace("iron");
            ResourceLocation diamond = ResourceLocation.withDefaultNamespace("diamond");
            processTier(tier, name, List.of(iron), List.of(diamond));
        } else {
            // Fallback: process with original values if unexpected tier
            TieredToolMod.getLogger().warn("Unexpected tier at ordinal 1: {} (expected GOLD). Processing with original values.", tier);
            processTier(tier, name, afters, befores);
        }
    }
}
