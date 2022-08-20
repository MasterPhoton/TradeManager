package minecraft.sbsdgrr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import minecraft.sbsdgrr.registry.ModBlocks;
import minecraft.sbsdgrr.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class TradeManager implements ModInitializer {
	private static final Logger log = LogManager.getLogger(TradeManager.class);

	public static final String MOD_ID = "trademanager";

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
