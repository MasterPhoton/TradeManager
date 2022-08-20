package minecraft.sbsdgrr.keybinds;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class ActionKey extends KeyBinding {
	public ActionKey() {
		super("Swap Elytra", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, "Trade Manager");
	}

}
