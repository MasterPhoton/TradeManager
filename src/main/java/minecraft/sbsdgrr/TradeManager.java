package minecraft.sbsdgrr;

import minecraft.sbsdgrr.keybinds.ActionKey;
import minecraft.sbsdgrr.registry.ModBlocks;
import minecraft.sbsdgrr.registry.ModItems;
import minecraft.sbsdgrr.registry.ModKeys;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TradeManager implements ModInitializer {
    private static final Logger log= LogManager.getLogger(TradeManager.class);

    public static final String MOD_ID= "trademanager";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModKeys.registerKeyBinds();

        try {
            ModKeys.keyPressEvents();
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("Logging is working");
    }

}
