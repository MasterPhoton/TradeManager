package minecraft.sbsdgrr.registry;

import minecraft.sbsdgrr.TradeManager;
import minecraft.sbsdgrr.blocks.VendingMachineBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	/* Creating a block */
	public static final VendingMachineBlock VENDING_MACHINE_BLOCK = new VendingMachineBlock();

	private ModBlocks() {
	}

	public static void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier(TradeManager.MOD_ID, "vending_machine_block"),
				VENDING_MACHINE_BLOCK);
	}

}
