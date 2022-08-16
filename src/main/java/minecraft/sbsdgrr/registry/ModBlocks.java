package minecraft.sbsdgrr.registry;

import minecraft.sbsdgrr.TradeManager;
import minecraft.sbsdgrr.blocks.VendingMachineBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModBlocks {
    /*Creatinga a block*/
//    public static final Block VENDING_MACHINE_BLOCK=new Block(FabricBlockSettings
//            .of(Material.DECORATION)
//            .requiresTool()
//            .strength(5.0f,9.9f)
//            .sounds(BlockSoundGroup.METAL)
//    );

    public static final VendingMachineBlock VENDING_MACHINE_BLOCK= new VendingMachineBlock();

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK,new Identifier(TradeManager.MOD_ID,"vending_machine_block"),VENDING_MACHINE_BLOCK);
    }


}
