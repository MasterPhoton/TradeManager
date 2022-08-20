package minecraft.sbsdgrr;

import minecraft.sbsdgrr.registry.ModKeys;
import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TradeManagerClient implements ClientModInitializer {
    private static final Logger log= LogManager.getLogger(TradeManagerClient.class);

    @Override
    public void onInitializeClient() {
        try {
            ModKeys.registerKeyBinds();
            ModKeys.keyPressEvents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("TradeManager clientMod Initilized");
    }


}
