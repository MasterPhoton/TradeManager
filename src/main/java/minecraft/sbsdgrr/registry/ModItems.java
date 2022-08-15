package minecraft.sbsdgrr.registry;

import minecraft.sbsdgrr.TradeManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {

    /*Creating the item objects*/
    public static final Item VENDING_MACHINE= new Item(new Item.Settings().group(ItemGroup.DECORATIONS).maxCount(1));

    /*Register The Items*/
    public static void registerItems(){
        Registry.register(Registry.ITEM,new Identifier(TradeManager.MOD_ID, "vendingmachine"), VENDING_MACHINE);
    }
}
