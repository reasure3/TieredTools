package com.reasure.tieredtools;

import com.reasure.tieredtools.util.ItemUtil;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = TieredToolMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TieredToolsSetup {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ItemUtil.modifyBaseAttribute((SwordItem) Items.GOLDEN_SWORD, 5.5f, -2.4);
            ItemUtil.modifyBaseAttribute((DiggerItem) Items.GOLDEN_AXE, 8.0f, -3.05);
            ItemUtil.modifyBaseAttribute((DiggerItem) Items.GOLDEN_PICKAXE, 3.5f, -2.8);
            ItemUtil.modifyBaseAttribute((DiggerItem) Items.GOLDEN_SHOVEL, 4.0f, -3.0);
            ItemUtil.modifyBaseAttribute((DiggerItem) Items.GOLDEN_HOE, 0.0f, -0.5);
            ItemUtil.modifyBaseAttribute((ArmorItem) Items.GOLDEN_HELMET, 3, 1.0f);
            ItemUtil.modifyBaseAttribute((ArmorItem) Items.GOLDEN_CHESTPLATE, 7, 1.0f);
            ItemUtil.modifyBaseAttribute((ArmorItem) Items.GOLDEN_LEGGINGS, 5, 1.0f);
            ItemUtil.modifyBaseAttribute((ArmorItem) Items.GOLDEN_BOOTS, 2, 1.0f);
        });
    }
}
