package minecraft.sbsdgrr;

import RohanTR.BoxBlock;
import RohanTR.BoxBlockEntity;
import RohanTR.BoxScreenHandler;
import minecraft.sbsdgrr.registry.ModBlocks;
import minecraft.sbsdgrr.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TradeManager implements ModInitializer {
    private static final Logger log = LogManager.getLogger(TradeManager.class);

    public static final String MOD_ID = "trademanager";

// ***********************************************************************************

    public static final Block BOX_BLOCK;
    public static final BlockItem BOX_BLOCK_ITEM;
    public static final BlockEntityType<BoxBlockEntity> BOX_BLOCK_ENTITY;
    // a public identifier for multiple parts of our bigger chest
    public static final Identifier BOX = new Identifier(MOD_ID, "box_block");
    public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER;

    static {
        BOX_BLOCK = Registry.register(Registry.BLOCK, BOX, new BoxBlock(FabricBlockSettings.copyOf(Blocks.CHEST)));
        BOX_BLOCK_ITEM = Registry.register(Registry.ITEM, BOX, new BlockItem(BOX_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        //The parameter of build at the very end is always null, do not worry about it
        // In 1.17 use FabricBlockEntityTypeBuilder instead of BlockEntityType.Builder
        BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BOX, BoxScreenHandler::new);
        BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, BOX, FabricBlockEntityTypeBuilder.create(BoxBlockEntity::new, BOX_BLOCK).build(null));
    }

// ***********************************************************************************


//    public void onInitializeServer() {
//        log.info("TradeManager Server Initialized ");
//    }

    @Override
    public void onInitialize() {
        try {
            ModItems.registerItems();
            ModBlocks.registerBlocks();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("TradeManager ModInit");
    }



}
