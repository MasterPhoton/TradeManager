package minecraft.sbsdgrr.registry;

import minecraft.sbsdgrr.Items.VendingMachineItem;
import minecraft.sbsdgrr.TradeManager;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems{

    /*Creating the item objects*/
//    public static final Item VENDING_MACHINE= new Item(new Item.Settings().group(ItemGroup.DECORATIONS).maxCount(1));
    public static final VendingMachineItem VENDING_MACHINE= new VendingMachineItem();
    public static final BlockItem VENDING_MACHINE_BLOCK=new BlockItem(ModBlocks.VENDING_MACHINE_BLOCK,new FabricItemSettings().group(ItemGroup.DECORATIONS).maxCount(1));

    /*Register The Items*/
    public static void registerItems(){
        Registry.register(Registry.ITEM,new Identifier(TradeManager.MOD_ID, "vendingmachine"), VENDING_MACHINE);
        Registry.register(Registry.ITEM,new Identifier(TradeManager.MOD_ID, "vending_machine_block"), VENDING_MACHINE_BLOCK);
    }

}
