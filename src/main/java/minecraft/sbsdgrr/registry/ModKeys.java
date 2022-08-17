package minecraft.sbsdgrr.registry;

import minecraft.sbsdgrr.keybinds.ActionKey;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.profiler.Sampler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.function.Predicate;

public class ModKeys {
    private static final Logger log = LogManager.getLogger(ModKeys.class);

    public static final ActionKey ACTION_KEY = new ActionKey();
    public static HashSet<ItemStack> items = new HashSet<>();

    public static void registerKeyBinds() {
        KeyBindingHelper.registerKeyBinding(ACTION_KEY);
    }

    public static void keyPressEvents() throws Exception {

        /*Creating even listener*/
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (ModKeys.ACTION_KEY.wasPressed()) {
                /*Player Entity*/
                PlayerEntity player = client.player;
                /*creating necessary variables*/
                int chest_slot = 38;
                int swap_slot = 100;
                ItemStack chestItem = null;
                ItemStack swapItem = null;
                int chestFlag = 0;
                int flight = 0;
                /*check if swapping possible or not*/
                if (!player.getInventory().getStack(38).isEmpty()) {
                    chestItem = player.getInventory().getStack(38);
                    chestFlag = 1;
                    log.info("Chest item on " + chestItem.toString());
                } else {
                    log.info("Must equip chest item before swapping");
                }
                /*checking for swap item in player inventory*/
                for (int i = 0; i <= 35; i++) {
                    if (!player.getInventory().getStack(i).isEmpty()) {
                        ItemStack item = player.getInventory().getStack(i);
                        if (chestFlag == 1 && chestItem.toString().contains("chestplate")) {
                            if (item.toString().contains("elytra")) {
                                swap_slot = i;
                                swapItem = item;
                                flight = 1;
                                log.info("arm=> " + chestItem.toString() + "|| found elytra");
                                chestFlag = 2;
                                break;
                            }
                        }
                        if (chestFlag == 1 && chestItem.toString().contains("elytra")) {
                            if (item.toString().contains("chestplate")) {
                                swap_slot = i;
                                swapItem = item;
                                log.info("fly=> " + chestItem.toString() + "|| found chestplate");
                                chestFlag = 2;
                                break;
                            }
                        }
                    }
                }
                /*check if all requirements are passed*/
                if (chestFlag < 2) {
                    player.sendMessage(Text.literal("Armor or Elytra not found in " + player.getDisplayName().getString() + " Inventory"), true);
                } else {
                    /*temp item var*/
                    ItemStack tempItem = swapItem;
                    Inventory inv=player.getInventory();
                    /*swap elytra with chestplate and display msg*/
                    if (flight == 0) {
                        if(player.isFallFlying()){
                            player.sendMessage(Text.of("Elyta is active"),false);
                        }
                        else{
                            player.getInventory().setStack(swap_slot, chestItem);
                            player.getInventory().setStack(chest_slot, tempItem);
                            player.getInventory().markDirty();
                            player.sendMessage(Text.literal("Flight Off"), true);
                        }
                    } else if (flight == 1) {
                        player.getInventory().setStack(swap_slot, chestItem);
                        player.getInventory().setStack(chest_slot, tempItem);
                        player.getInventory().markDirty();
                        player.sendMessage(Text.literal("Flight On"), true);
                    }
                }


//                int val=client.world.getScoreboard().getPlayerScore(player.getDisplayName().getString(),client.world.getScoreboard().getObjective("constant")).getScore();
//                log.info(val);

            }
        });


    }


}
