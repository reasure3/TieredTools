package com.reasure.tieredtools;

import com.reasure.tieredtools.util.ItemUtil;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = TieredToolMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TieredToolsSetup {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // Golden Axe: 9 Attack Damage (1 base + 8 bonus), 0.95 Attack Speed
            // Balanced between Iron (9 dmg, 0.9 speed) and Diamond (9 dmg, 1.0 speed)
            ItemUtil.modifyBaseAttribute((DiggerItem) Items.GOLDEN_AXE, 8.0f, -3.05);
            TieredToolMod.getLogger().info("Golden Axe modified: 9 attack damage, 0.95 attack speed");

            // Golden Hoe: 1 Attack Damage (1 base + 0 bonus), 3.5 Attack Speed
            // Faster than Iron (1 dmg, 3.0 speed) but slower than Diamond (1 dmg, 4.0 speed)
            ItemUtil.modifyBaseAttribute((DiggerItem) Items.GOLDEN_HOE, 0.0f, -0.5);
            TieredToolMod.getLogger().info("Golden Hoe modified: 1 attack damage, 3.5 attack speed");
        });
    }
}
