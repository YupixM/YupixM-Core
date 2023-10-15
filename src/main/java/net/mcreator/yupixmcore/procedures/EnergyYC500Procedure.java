package net.mcreator.yupixmcore.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import net.mcreator.yupixmcore.YupixmCoreMod;

import java.util.Map;

public class EnergyYC500Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				YupixmCoreMod.LOGGER.warn("Failed to load dependency world for procedure EnergyYC500!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				YupixmCoreMod.LOGGER.warn("Failed to load dependency x for procedure EnergyYC500!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				YupixmCoreMod.LOGGER.warn("Failed to load dependency y for procedure EnergyYC500!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				YupixmCoreMod.LOGGER.warn("Failed to load dependency z for procedure EnergyYC500!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		{
			TileEntity _ent = world.getTileEntity(new BlockPos(x, y, z));
			int _amount = (int) 500;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
		}
	}
}
