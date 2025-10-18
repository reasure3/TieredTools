package com.reasure.tieredtools.mixin;

import com.reasure.tieredtools.util.TieredToolsTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow
    public abstract boolean is(TagKey<Item> tag);

    @Inject(method = "isDamageableItem", at = @At("HEAD"), cancellable = true)
    private void checkUnbreakable(CallbackInfoReturnable<Boolean> cir) {
        if (this.is(TieredToolsTags.UNBREAKABLE)) {
            cir.setReturnValue(false);
        }
    }
}
