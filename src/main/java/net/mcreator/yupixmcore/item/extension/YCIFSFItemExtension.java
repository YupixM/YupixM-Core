
package net.mcreator.yupixmcore.item.extension;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.World;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.Blocks;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class YCIFSFItemExtension {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		DispenserBlock.registerDispenseBehavior(Blocks.SOUL_FIRE.asItem(), new OptionalDispenseBehavior() {
			public ItemStack dispenseStack(IBlockSource blockSource, ItemStack stack) {
				ItemStack itemstack = stack.copy();
				World world = blockSource.getWorld();
				Direction direction = blockSource.getBlockState().get(DispenserBlock.FACING);
				int x = blockSource.getBlockPos().getX();
				int y = blockSource.getBlockPos().getY();
				int z = blockSource.getBlockPos().getZ();
				this.setSuccessful(true);
				if (this.isSuccessful())
					itemstack.shrink(1);
				return itemstack;
			}
		});
	}

	@Mod.EventBusSubscriber
	public static class Fuel {
		@SubscribeEvent
		public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
			ItemStack itemstack = event.getItemStack();
			if (itemstack.getItem() == Blocks.SOUL_FIRE.asItem())

				event.setBurnTime(0);
		}
	}
}
