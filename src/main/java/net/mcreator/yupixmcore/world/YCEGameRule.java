package net.mcreator.yupixmcore.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.mcreator.yupixmcore.YupixmCoreModElements;

import java.lang.reflect.Method;

@YupixmCoreModElements.ModElement.Tag
public class YCEGameRule extends YupixmCoreModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("yCE", GameRules.Category.UPDATES, create(true));

	public YCEGameRule(YupixmCoreModElements instance) {
		super(instance, 13);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
