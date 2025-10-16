package com.reasure.tieredtools;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(TieredToolMod.MODID)
public class TieredToolMod {
    public static final String MODID = "tieredtools";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TieredToolMod() {
		
    }

    public static ResourceLocation loc(String path) {
        //noinspection removal
        return new ResourceLocation(MODID, path);
    }
}
