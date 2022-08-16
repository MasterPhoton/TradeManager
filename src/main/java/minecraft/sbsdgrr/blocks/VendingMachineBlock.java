package minecraft.sbsdgrr.blocks;

import minecraft.sbsdgrr.registry.ModBlocks;
import minecraft.sbsdgrr.registry.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.PlayerSkullBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class VendingMachineBlock extends Block {
    public VendingMachineBlock() {
        super(FabricBlockSettings.of(Material.DECORATION)
                .requiresTool()
                .strength(5.0f, 2.0f)
                .sounds(BlockSoundGroup.METAL)
        );
    }

}
