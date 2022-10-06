/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package minecraft.sbsdgrr.blocks;

import minecraft.sbsdgrr.TradeManager;
import minecraft.sbsdgrr.screen.VendingMachineScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class VendingMachineBlockEntity extends LootableContainerBlockEntity implements ExtendedScreenHandlerFactory {
	private DefaultedList<ItemStack> items = DefaultedList.ofSize(size(), ItemStack.EMPTY);

	public VendingMachineBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(TradeManager.VENDINGMACHINEBLOCK_ENTITY, blockPos, blockState);
	}

	@Override
	protected DefaultedList<ItemStack> getInvStackList() {
		return items;
	}

	@Override
	protected void setInvStackList(DefaultedList<ItemStack> list) {
		this.items = list;
	}

	@Override
	protected Text getContainerName() {
		return Text.translatable(getCachedState().getBlock().getTranslationKey());
	}

	@Override
	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new VendingMachineScreenHandler(syncId, playerInventory, this);
	}

	@Override
	public int size() {
		return 9 * 3;
	}

	@Override
	public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
		buf.writeBlockPos(pos);
	}
}
