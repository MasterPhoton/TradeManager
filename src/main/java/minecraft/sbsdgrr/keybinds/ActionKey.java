package minecraft.sbsdgrr.keybinds;

import minecraft.sbsdgrr.registry.ModKeys;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

public class ActionKey extends KeyBinding {
    private static final Logger log= LogManager.getLogger(ActionKey.class);
    public ActionKey() {
        super("Swap Elytra",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "Trade Manager");
    }



}
