package minecraft.sbsdgrr.items;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import com.mojang.brigadier.CommandDispatcher;

import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class VendingMachineItem extends Item {
	private static final Logger log = LogManager.getLogger(VendingMachineItem.class);
	private static @Nullable CommandDispatcher<FabricClientCommandSource> activeDispatcher;

	public VendingMachineItem() {
		/* different Item Settings */
		super(new FabricItemSettings().group(ItemGroup.DECORATIONS).maxCount(1));
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		World world = context.getWorld();
		log.info(context.getBlockPos());
		if (!world.isClient()) {
			/* action on server */
			world.setBlockState(context.getBlockPos(), Blocks.DIAMOND_BLOCK.getDefaultState());
		} else {
			/* play sound */
			context.getPlayer().playSound(SoundEvents.BLOCK_ANVIL_LAND, 3.0f, 0.5f);
		}
		return super.useOnBlock(context);
	}

	@SuppressWarnings("resource")
	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
		if (!user.getWorld().isClient && hand == Hand.MAIN_HAND) {
			user.sendMessage(Text.of(entity.getEntityName()));
			user.sendMessage(Text.of(entity.getDisplayName().getString()));
		}
		return super.useOnEntity(stack, user, entity, hand);
	}
}
