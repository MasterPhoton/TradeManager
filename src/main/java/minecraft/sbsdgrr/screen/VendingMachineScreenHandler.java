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

package minecraft.sbsdgrr.screen;

import minecraft.sbsdgrr.TradeManager;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.BlockPos;

public class VendingMachineScreenHandler extends Generic3x3ContainerScreenHandler implements PositionedScreenHandler {
	private final BlockPos pos;

	public VendingMachineScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
		super(syncId, playerInventory);
		this.pos = buf.readBlockPos();
	}

	public VendingMachineScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(syncId, playerInventory, inventory);
		this.pos = BlockPos.ORIGIN;
	}

	@Override
	public BlockPos getPos() {
		return pos;
	}

	@Override
	public ScreenHandlerType<?> getType() {
		return TradeManager.VENDINGMACHINEBLOCK_SCREEN_HANDLER;
	}
}
