package minecraft.sbsdgrr;

import minecraft.sbsdgrr.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class TradeManager implements ModInitializer {

    public static final String MOD_ID= "trademanager";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
    }
}
