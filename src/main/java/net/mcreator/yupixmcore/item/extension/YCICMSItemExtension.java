
package net.mcreator.yupixmcore.item.extension;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.World;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.Blocks;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class YCICMSItemExtension {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ComposterBlock.CHANCES.put(Blocks.MELON_STEM.asItem(), 0.2f);
		DispenserBlock.registerDispenseBehavior(Blocks.MELON_STEM.asItem(), new OptionalDispenseBehavior() {
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
}
