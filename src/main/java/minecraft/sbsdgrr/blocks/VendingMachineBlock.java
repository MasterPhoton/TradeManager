package minecraft.sbsdgrr.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class VendingMachineBlock extends Block {
	public VendingMachineBlock() {
		super(FabricBlockSettings.of(Material.DECORATION).requiresTool().strength(5.0f, 2.0f)
				.sounds(BlockSoundGroup.METAL));
	}

}
