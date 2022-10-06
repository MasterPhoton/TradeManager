package minecraft.sbsdgrr;

import minecraft.sbsdgrr.screen.BuyPositionedScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.fabricmc.api.ClientModInitializer;

public class TradeManagerClient implements ClientModInitializer {
	private static final Logger log = LogManager.getLogger(TradeManagerClient.class);

	@Override
	public void onInitializeClient() {
		log.info("TradeManager clientMod Initialized");

		HandledScreens.register(TradeManager.VENDINGMACHINEBLOCK_SCREEN_HANDLER, BuyPositionedScreen::new);
	}
}
