package doph.niho.cookmod.init;

import doph.niho.cookmod.system.Define;
import net.minecraft.item.ItemFood;

public class BaseFood extends ItemFood {
	public BaseFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setFull3D();
		this.setRegistryName(Define.MODID, name);
		this.setCreativeTab(CookCreativeTab.cookModFood);
	}
}
