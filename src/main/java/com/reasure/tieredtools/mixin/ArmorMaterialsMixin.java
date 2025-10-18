package com.reasure.tieredtools.mixin;

import com.reasure.tieredtools.TieredToolMod;
import net.minecraft.Util;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.EnumMap;

@Mixin(ArmorMaterials.class)
public class ArmorMaterialsMixin {
    @Shadow @Final @Mutable
    private EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;

    @Shadow @Final @Mutable
    private float toughness;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyGoldMaterial(CallbackInfo ci) {
        // Buff gold material stats to make it viable between iron and diamond
        TieredToolMod.getLogger().info("Modifying Gold Armor Stats: protection(boots/leggings/chestplate/helmet) [1/3/5/7]->[2/5/7/3], toughness 0.0->1.0");
        ArmorMaterialsMixin gold = (ArmorMaterialsMixin) (Object) ArmorMaterials.GOLD;
        gold.protectionFunctionForType = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 2);
            map.put(ArmorItem.Type.LEGGINGS, 5);
            map.put(ArmorItem.Type.CHESTPLATE, 7);
            map.put(ArmorItem.Type.HELMET, 3);
        });
        gold.toughness = 1.0f;
    }
}
