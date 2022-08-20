package minecraft.sbsdgrr.registry;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import minecraft.sbsdgrr.keybinds.ActionKey;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

public class ModKeys {
	private static final Logger log = LogManager.getLogger(ModKeys.class);

	public static final ActionKey ACTION_KEY = new ActionKey();
	protected static Set<ItemStack> items = new HashSet<>();

	private ModKeys() {
	}

	public static void registerKeyBinds() {
		KeyBindingHelper.registerKeyBinding(ACTION_KEY);
	}

	public static void keyPressEvents() {
		/* Creating even listener */
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (ModKeys.ACTION_KEY.wasPressed()) {
				/* Player Entity */
				PlayerEntity player = client.player;
				/* creating necessary variables */
				int chestSlot = 38;
				int swapSlot = 100;
				ItemStack chestItem = null;
				int chestFlag = 0;
				int flight = 0;
				/* check if swapping possible or not */
				if (!player.getInventory().getStack(chestSlot).isEmpty()) {
					chestItem = player.getInventory().getStack(chestSlot);
					chestFlag = 1;
					log.info(("Chest item on " + chestItem.toString()));
				} else {
					log.info("Must equip chest item before swapping");
				}
				/* checking for swap item in player inventory */
				boolean flag = false;
				for (int i = 0; i <= 35; i++) {
					if (!player.getInventory().getStack(i).isEmpty()) {
						ItemStack item = player.getInventory().getStack(i);
						if (chestFlag == 1 && chestItem.toString().contains("chestplate")
								&& item.toString().contains("elytra")) {
							swapSlot = i;
							flight = 1;
							log.info(("arm=> " + chestItem.toString() + "|| found elytra"));
							chestFlag = 2;
							flag = true;

						}
						if (!flag && chestFlag == 1 && chestItem.toString().contains("elytra")
								&& item.toString().contains("chestplate")) {
							swapSlot = i;
							log.info(("fly=> " + chestItem.toString() + "|| found chestplate"));
							chestFlag = 2;
							flag = true;
						}
						if (flag) {
							break;
						}
					}
				}
				/* check if all requirements are passed */
				if (chestFlag < 2) {
					player.sendMessage(Text.literal(
							"Armor or Elytra not found in " + player.getDisplayName().getString() + " Inventory"),
							true);
				} else {
					player.getInventory();

					/* exp */
					ClientPlayerInteractionManager interactionManager = client.interactionManager;
					new SimpleInventory();

					/*
					 * interaction button starts from Hotbar[1-9] then it takes slot values. quite
					 * complicated
					 */
					swapSlot = (swapSlot < 9) ? (swapSlot + 36) : swapSlot;

					/* swap elytra with chest plate and display msg */
					if (flight == 0) {
						if (player.isFallFlying()) {
							player.sendMessage(Text.literal("Elytra is active"), true);
						} else {
							interactionManager.clickSlot(player.playerScreenHandler.syncId, swapSlot, chestSlot,
									SlotActionType.SWAP, player);
							player.sendMessage(Text.literal("Flight Off"), true);
						}
					} else if (flight == 1) {
						interactionManager.clickSlot(player.playerScreenHandler.syncId, swapSlot, chestSlot,
								SlotActionType.SWAP, player);
						player.sendMessage(Text.literal("Flight On"), true);
					}
				}

			}
		});

	}

}
