package com.reasure.tieredtools;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TieredToolMod.MODID)
public class TieredToolsEvents {
    private static final Component UNBREAKABLE_TOOLTIP = Component.translatable("tooltip.tieredtools.item.unbreakable");

    @SubscribeEvent
    public static void addTooltips(ItemTooltipEvent event) {
        ItemStack item = event.getItemStack();
        if (item.is(TieredToolsTags.UNBREAKABLE)) {
            event.getToolTip().add(UNBREAKABLE_TOOLTIP);
        }
    }
}
