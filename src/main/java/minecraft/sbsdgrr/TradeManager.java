package minecraft.sbsdgrr;

import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.schemas.Schema;
import minecraft.sbsdgrr.registry.ModBlocks;
import minecraft.sbsdgrr.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TradeManager implements ModInitializer {
    private static final Logger log = LogManager.getLogger(TradeManager.class);

    public static final String MOD_ID = "trademanager";


//    public void onInitializeServer() {
//        log.info("TradeManager Server Initialized ");
//    }

    @Override
    public void onInitialize() {
        try {
            ModItems.registerItems();
            ModBlocks.registerBlocks();
        } catch (Exception e) {
            e.printStackTrace();
        }



        log.info("TradeManager ModInit");
    }



}
