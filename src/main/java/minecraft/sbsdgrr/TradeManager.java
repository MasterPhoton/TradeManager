package minecraft.sbsdgrr;

import minecraft.sbsdgrr.blocks.VendingMachineBlock;
import minecraft.sbsdgrr.blocks.VendingMachineBlockEntity;
import minecraft.sbsdgrr.screen.VendingMachineScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TradeManager implements ModInitializer {
    public static final String ID = "trademanager";

    public static final Block VENDINGMACHINEBLOCK = new VendingMachineBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD));
    public static final Item VENDINGMACHINEBLOCK_ITEM = new BlockItem(VENDINGMACHINEBLOCK, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockEntityType<VendingMachineBlockEntity> VENDINGMACHINEBLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(VendingMachineBlockEntity::new, VENDINGMACHINEBLOCK).build();
    public static final ScreenHandlerType<VendingMachineScreenHandler> VENDINGMACHINEBLOCK_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(VendingMachineScreenHandler::new);

    public static Identifier id(String path) {
        return new Identifier(ID, path);
    }

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, id("vending_machine_block"), VENDINGMACHINEBLOCK);
        Registry.register(Registry.ITEM, id("vending_machine_block"), VENDINGMACHINEBLOCK_ITEM);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, id("vending_machine_block"), VENDINGMACHINEBLOCK_ENTITY);
        Registry.register(Registry.SCREEN_HANDLER, id("vending_machine_block"), VENDINGMACHINEBLOCK_SCREEN_HANDLER);
    }
}
